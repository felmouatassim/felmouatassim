package org.brilliant.farouk.RagingRooks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RagingRooks {
	public static List<Position> readPositions(String fileName) throws NumberFormatException, IOException {
		FileInputStream io = new FileInputStream("RagingRocks.txt");
		InputStreamReader isr = new InputStreamReader(io);
		BufferedReader fr = new BufferedReader(isr);
		String ligne;
		List<Position> list = new ArrayList<Position>();
		Set<Integer> listX = new HashSet<Integer>();
		Set<Integer> listY = new HashSet<Integer>();
		
		Position position = new Position();
		while ((ligne = fr.readLine()) != null) {
			position.setX(new Integer(ligne.substring(0, ligne.indexOf(" "))));
			position.setY(new Integer(ligne.substring(ligne.indexOf(" ")+1)));
			listX.add(new Integer(ligne.substring(0, ligne.indexOf(" "))));
			listY.add(new Integer(ligne.substring(ligne.indexOf(" ")+1)));
			System.out.println("x = "+position.getX()+" - y = "+position.getY());
			list.add(position);
		}
		System.out.println(listX.size());
		System.out.println(listY.size());
		fr.close();
		
		return list;
		
	}
	
	public static void main(String[] args) {
		List<Position> positionList = new ArrayList<Position>();
		try {
			positionList = readPositions("RagingRocks.txt");
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
