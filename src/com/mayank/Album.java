package com.mayank;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album{
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	public Album(String name,String artist ){
		this.name=name;
		this.artist=artist;
		this.songs= new ArrayList<Song>();
	}
	public Album() {
		
	}
	
	
	
	public Song findSong(String title){
		for(Song checkSong : this.songs) {
			if(checkSong.getTitle().equals(title)) return checkSong;
		}
		return null;
	}
	
	public boolean addSong(String title ,double duration ) {
		if(findSong(title)==null) {
			songs.add(new Song(title,duration));
		//	System.out.println(title+"Successfully added to the List");
			return true;
		}
		else {
			//System.out.println("Song Name"+ title+" already exist in the list");
			return false;
		}
	}

	
	public void addtoPlayList(String title , LinkedList<Song> PlayList) {
		for(Song checkSong : this.songs) {
			if(checkSong.getTitle().equals(title)) PlayList.add(checkSong);
			else {
			//	System.out.println("The is No Such Song in the album named "+title);
			}
		}
	}
}