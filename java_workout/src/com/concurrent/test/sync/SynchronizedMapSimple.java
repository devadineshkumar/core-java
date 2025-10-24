package com.concurrent.test.sync;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ConcurrentModificationException;

/**
 * Simple demo showing Collections.synchronizedMap(...) and iteration rules.
 * <p>
 * It runs two short scenarios using the same synchronizedMap:
 * 1) Reader iterates WITHOUT synchronizing on the map -> may see ConcurrentModificationException
 * 2) Reader iterates WITH synchronized(map) -> safe iteration
 * <p>
 * Compile:
 * javac SynchronizedMapSimple.java
 * Run:
 * java SynchronizedMapSimple
 */
public class SynchronizedMapSimple {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Simple demo of Collections.synchronizedMap()");

        // Create a synchronized wrapper around a HashMap
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

        System.out.println("\n--- Scenario A: iterate WITHOUT external synchronization (may fail) ---");
        runScenario(map, false);

        // Make a fresh map for the next scenario
        map = Collections.synchronizedMap(new HashMap<>());

        System.out.println("\n--- Scenario B: iterate WITH external synchronization (safe) ---");
        runScenario(map, true);

        System.out.println("\nDone.");
    }

    /**
     * Runs a short writer + reader scenario.
     *
     * @param map                    the shared map
     * @param readerUsesExternalSync if true, reader synchronizes on the map when iterating
     */
    private static void runScenario(final Map<String, Integer> map, final boolean readerUsesExternalSync)
            throws InterruptedException {

        final Thread writer = new Thread(() -> {
            // writer adds entries slowly so reader has a chance to iterate concurrently
            for (int i = 0; i < 500; i++) {
                map.put("key-" + i, i);
                if ((i % 50) == 0) {
                    // pause a bit to increase interleaving
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }, "Writer");

        final Thread reader = new Thread(() -> {
            int cmeCount = 0;
            // try several iterations
            for (int loop = 0; loop < 200; loop++) {
                try {
                    if (readerUsesExternalSync) {
                        // Correct: lock the map before iterating its collection views
                        synchronized (map) {
                            for (Map.Entry<String, Integer> e : map.entrySet()) {
                                // touch entries to simulate work
                                e.getKey().length();
                            }
                        }
                    } else {
                        // Intentionally NOT synchronizing: this may throw ConcurrentModificationException
                        for (Map.Entry<String, Integer> e : map.entrySet()) {
                            e.getKey().length();
                        }
                    }
                } catch (ConcurrentModificationException ex) {
                    cmeCount++;
                    // swallow and continue, counting failures
                }

                // small pause
                try {
                    Thread.sleep(2);
                } catch (InterruptedException ignored) {
                }
            }
            System.out.println("Reader finished. ConcurrentModificationException count = " + cmeCount);
        }, "Reader");

        // Start both threads
        writer.start();
        reader.start();

        // Wait for completion
        writer.join();
        reader.join();

        System.out.println("Final map size: " + map.size());
    }
}