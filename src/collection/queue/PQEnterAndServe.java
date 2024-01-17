package collection.queue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/***
 * sample input : 
 * 12 
 * ENTER John 3.75 50 
 * ENTER Mark 3.8 24 
 * ENTER Shafaet 3.7 35
 * SERVED 
 * SERVED 
 * ENTER Samiha 3.85 36 SERVED ENTER Ashley 3.9 42 ENTER Maria 3.6
 * 46 ENTER Anik 3.95 49 ENTER Dan 3.95 50 SERVED
 * 
 * Output: Dan Ashley Shafaet Maria
 * 
 * @author Jorja Estrope
 *
 */
class Student implements Comparable<Student> {
	int id;
	String name;
	double cgpa;
	List<Student> events;

	public Student(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}

	@Override
	public int compareTo(Student student) {
		return Double.compare(student.cgpa, this.cgpa) == 0 ? this.name.compareTo(student.name) : Double.compare(student.cgpa, this.cgpa);
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.cgpa;
	}

}

public class PQEnterAndServe {

	public static void main(String[] args){
		
		Scanner scanEvents = new Scanner(System.in);
		int size = scanEvents.nextInt();

		List<String> eventList = new ArrayList<>();
		for(int i=0; i<=size; i++) {
			eventList.add(scanEvents.nextLine());
		}

		scanEvents.close();

		PriorityQueue<Student> pqOfStudents = getStudents(eventList);

		if (pqOfStudents.isEmpty())
			System.out.println("EMPTY");
		else
			while(pqOfStudents.iterator().hasNext()) {
				System.out.println(pqOfStudents.poll().getName());
			}
		
	}

	public static PriorityQueue<Student> getStudents(List<String> events) {

		PriorityQueue<Student> pq = new PriorityQueue<>();

		for (int i = 1; i < events.size(); i++) {
			if (events.get(i).contains("ENTER")) {
				String arrStr[] = events.get(i).split("\\s+");
				pq.add(new Student(Integer.valueOf(arrStr[3]), arrStr[1], Double.valueOf(arrStr[2])));
				//pq.stream().sorted();
			} else if (events.get(i).contains("SERVED")) {
				pq.poll();
			}

		}

		//List<Student> newlist = new ArrayList<>();
		//pq.stream().sorted();

		return pq;
	}
}
