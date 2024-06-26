package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Set<LogEntry> duser = new HashSet<>();
			
			String line = br.readLine();
			while(line != null) {
				
				String [] dataUser = line.split(" ");
				Instant dt = Instant.parse(dataUser[1]);
				
				duser.add(new LogEntry(dataUser[0], dt));
				
				line = br.readLine();
			}
			
			System.out.println();
			
			System.out.println("Total users: "+ duser.size());
			
		}catch(IOException e) {
			System.out.println("Error! "+e.getMessage());
		}
		sc.close();
	}

}
