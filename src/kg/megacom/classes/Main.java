package kg.megacom.classes;

import kg.megacom.enums.Hotels;
import kg.megacom.enums.Rooms;
import kg.megacom.enums.Stars;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Information> informationList = new ArrayList<>();
        informationList.add(new Information("Jumeirah Village", 8000, Hotels.RESORT, Rooms.DELUXE_ROOM, Stars.FOUR_STAR));
        informationList.add(new Information("Atana Hotel", 6010, Hotels.AIRPORT_HOTEL, Rooms.CABANA_ROOM, Stars.FIVE_STAR));
        informationList.add(new Information("Atlantis Hotel", 7500, Hotels.AIRPORT_HOTEL, Rooms.PRESIDENTIAL_SUITE, Stars.FIVE_STAR));
        informationList.add(new Information("The Meydan Hotel", 4000, Hotels.FLOATING_HOTEL, Rooms.DOUBLE_ROOM, Stars.TREE_STAR));
        informationList.add(new Information("The Meydan Hotel", 2600, Hotels.FLOATING_HOTEL, Rooms.DOUBLE_ROOM, Stars.TREE_STAR));
        informationList.add(new Information("Meydan Hotel", 2800, Hotels.FLOATING_HOTEL, Rooms.DOUBLE_ROOM, Stars.TREE_STAR));
        informationList.add(new Information("Grand Hyatt", 3000, Hotels.BOATEL, Rooms.LANAI_ROOM, Stars.FOUR_STAR));
        informationList.add(new Information("Ak keme", 4500, Hotels.SELF_CATERING_HOTEL, Rooms.DUPLEX_ROOM, Stars.ONE_STAR));
        informationList.add(new Information("Sofitel Dubai The Obelisk", 2999, Hotels.SUBURB_HOTEL, Rooms.SINGLE_ROOM, Stars.ONE_STAR));
        informationList.add(new Information("Palm Jumeirah", 2300, Hotels.MOTEL, Rooms.TWIN_ROOM, Stars.TWO_STAR));
        informationList.add(new Information("Sheraton Grand Hotel", 9000, Hotels.ROTEL, Rooms.PRESIDENTIAL_SUITE, Stars.FIVE_STAR));

        Stream<Object> informationStream2 = Stream.builder()
                .add(new Information("Jumeirah Village", 8000, Hotels.RESORT, Rooms.DELUXE_ROOM, Stars.FOUR_STAR))
                .add(new Information("Atana Hotel", 6000, Hotels.AIRPORT_HOTEL, Rooms.CABANA_ROOM, Stars.FIVE_STAR))
                .add(new Information("The Meydan Hotel", 4000, Hotels.FLOATING_HOTEL, Rooms.DOUBLE_ROOM, Stars.TREE_STAR))
                .add(new Information("Grand Hyatt", 3000, Hotels.BOATEL, Rooms.LANAI_ROOM, Stars.FOUR_STAR))
                .add(new Information("Ak keme", 4500, Hotels.SELF_CATERING_HOTEL, Rooms.DUPLEX_ROOM, Stars.ONE_STAR))
                .add(new Information("Sofitel Dubai The Obelisk", 5000, Hotels.SUBURB_HOTEL, Rooms.SINGLE_ROOM, Stars.ONE_STAR))
                .add(new Information("Palm Jumeirah", 2300, Hotels.MOTEL, Rooms.TWIN_ROOM, Stars.TWO_STAR))
                .add(new Information("Sheraton Grand Hotel", 5000, Hotels.ROTEL, Rooms.PRESIDENTIAL_SUITE, Stars.FIVE_STAR))
                .build();
        System.out.println("\n-----------------------------------------------------------------List of hotels (Stream.builder)");
        informationStream2.forEach(System.out::println);
        System.out.println("\n---------------------------------------------------------------------------------Five star hotels");
        informationList.stream().filter((s) -> s.getStars().equals(Stars.FIVE_STAR)).forEach(System.out::println);
        System.out.println("\n----------------------------------------------------------------------------------Four star hotels");
        informationList.stream().filter((s) -> s.getStars().equals(Stars.FOUR_STAR)).forEach(System.out::println);
        System.out.println("\n--------------------------------------------------------------------------Quantity of hotels");
        System.out.println("Quantity of AIRPORT_HOTEL = " + informationList.stream().filter((x) -> x.getHotel().equals(Hotels.AIRPORT_HOTEL)).count());
        System.out.println("Quantity of FLOATING_HOTEL = " + informationList.stream().filter((x) -> x.getHotel().equals(Hotels.FLOATING_HOTEL)).count());
        System.out.println("Quantity of SUBURB_HOTEL = " + informationList.stream().filter((x) -> x.getHotel().equals(Hotels.SUBURB_HOTEL)).count());
        System.out.println("Quantity of SELF_CATERING_HOTEL = " + informationList.stream().filter((x) -> x.getHotel().equals(Hotels.SELF_CATERING_HOTEL)).count());
        System.out.println("\n--------------------------------------------------------------The cost of rooms are more than 3000");
        informationList.stream().filter(n -> n.getCost() > 3000).forEach(System.out::println);
        System.out.println("\n--------------------------------------------------------------The cost of rooms are less than 3000");
        informationList.stream().filter(n -> n.getCost() < 3000).forEach(System.out::println);
        System.out.println("\n---------------------------------------------------------------------------------------Sort by price");
        List<Information> sorted = informationList.stream().sorted(Comparator.comparingInt(Information::getCost)).collect(Collectors.toList());
        sorted.forEach(System.out::println);
        System.out.println("\n----------------------------------------------------------------------------------------Sort by name");
        List<Information> sortedByName = informationList.stream().sorted(Comparator.comparing(Information::getName)).collect(Collectors.toList());
        sortedByName.forEach(System.out::println);
        System.out.println("\n----------------------------------------------------------------------------------------Sort by star");
        List<Information> sortedByHotel = informationList.stream().sorted(Comparator.comparing(Information::getStars)).collect(Collectors.toList());
        sortedByHotel.forEach(System.out::println);

    }
}
