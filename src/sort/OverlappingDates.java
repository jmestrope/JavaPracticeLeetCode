package sort;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class RentalTime {
	private Date start, end;

	public RentalTime(Date start, Date end) {
		this.start = start;
		this.end = end;
	}

	public Date getStart() {
		return this.start;
	}

	public Date getEnd() {
		return this.end;
	}
}

public class OverlappingDates {

	public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {
		
		Comparator<RentalTime> sorting = new Comparator<RentalTime>() {
			@Override
			public int compare(RentalTime o1, RentalTime o2) {
				int i = o1.getStart().compareTo(o2.getStart()); // Ascending order
				System.out.println(i + " " + o1.getStart().toString() + " " + o2.getStart().toString());
				return i;
			}
		};

		List<RentalTime> list = rentalTimes.stream().sorted(sorting).collect(Collectors.toList());

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				// how to check date 1 overlaps with date 2 ?
				// black listing
				// 1. start date of 2nd should not be before end date of 1st
				if (list.get(j).getStart().before(list.get(i).getEnd())) { //if logic 1 is true, 
					return false; //returns false, cannot be schedule
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

		ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();

		rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
		//rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
		rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));
		//rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 21:59"), sdf.parse("03/05/2020 23:00")));
		System.out.println(OverlappingDates.canScheduleAll(rentalTimes));
	}

}
