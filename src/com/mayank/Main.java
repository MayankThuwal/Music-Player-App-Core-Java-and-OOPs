package com.mayank;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1","AC/DC");

        album.addSong("TNT",4.5);
        album.addSong("Highway to hell",3.5);
        album.addSong("ThunderStruck",5.0);
        albums.add(album);

        album = new Album("Album2","Eminem");

        album.addSong("Rap god",4.5);
        album.addSong("Not Afraid",3.5);
        album.addSong("Lose yourself",4.5);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addtoPlayList("TNT",playList_1);
        albums.get(0).addtoPlayList("Highway to hell",playList_1);
        albums.get(1).addtoPlayList("Rap god",playList_1);
        albums.get(1).addtoPlayList("Lose yourself",playList_1);

        Scanner sc = new Scanner(System.in);
        System.out.println("0 - To Start Mp3 Player");
        int n = sc.nextInt();
        //sc.close();
        if(n==0) {
        	play(playList_1);
        }
    }

    private static void play(LinkedList<Song> PlayList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = PlayList.listIterator();

        if(PlayList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
        }
        printMenu();

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 1:
                    System.out.println("Playlist complete");
                    quit = true;
                    sc.close();
                    break;

                case 2:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("no song availble, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("You are at the first song");
                        forward = false;
                    }
                    break;

                case 4:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 5:
                    printList(PlayList);
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    if (PlayList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println(
        		"1 - to quit\n"+
                "2 - to play next song\n"+
                "3 - to play previous song\n"+
                "4 - to replay the current song\n"+
                "5 - list of all songs \n"+
                "6 - print all available options\n"+
                "7 - delete current song");
    }

    private static void printList(LinkedList<Song> PlayList){
        Iterator<Song> iterator = PlayList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }

}