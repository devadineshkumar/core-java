package com.concurrent.test;

public class TestStream {

    public static void main(String[] args) {

//        List<com.concurrent.test.ContentVersionDto> dtos = new ArrayList<>();
//        IntStream.range(0, 10).parallel().forEach(i -> {
//            dtos.add(new com.concurrent.test.ContentVersionDto(null, String.valueOf(i), null, null, null));
//        });
//
//        DoubleSummaryStatistics summary = dtos.stream().collect(Collectors.summarizingDouble(dto -> Double.parseDouble(dto.getContentVersion())));
//
//        List<ContentVersionDto> response = dtos.stream().collect(Collectors.filtering(dto -> dto.getContentVersion().equals("1.0"),
//                Collectors.toList()));
//
//        List<String> response2 = dtos.stream().collect(Collectors.collectingAndThen(
//                Collectors.mapping(ContentVersionDto::getObjectName, Collectors.toList()),
//                list -> list.stream().sorted().toList()
//        ));
//        System.out.println(response2);
    }
}
