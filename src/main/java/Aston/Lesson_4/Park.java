package Aston.Lesson_4;

public class Park {
    private String name;
    private Attraction[] attractions;

    public Park(String name) {
        this.name = name;
        this.attractions = new Attraction[0];
    }

    public void addAttraction(String name, String schedule, int price) {
        Attraction newAttraction = new Attraction(name, schedule, price);
        Attraction[] updatedAttractions = new Attraction[attractions.length + 1];
        System.arraycopy(attractions, 0, updatedAttractions, 0, attractions.length);
        updatedAttractions[attractions.length] = newAttraction;
        attractions = updatedAttractions;
    }

    public void displayAttractions() {
        System.out.println("Attractions in " + name + ":");
        for (Attraction attraction : attractions) {
            System.out.println("Name: " + attraction.getName());
            System.out.println("Schedule: " + attraction.getSchedule());
            System.out.println("Price: " + attraction.getPrice());
            System.out.println("---------------------------");
        }
    }

    public class Attraction {
        private String name;
        private String schedule;
        private int price;

        public Attraction(String name, String schedule, int price) {
            this.name = name;
            this.schedule = schedule;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getSchedule() {
            return schedule;
        }

        public int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        Park park = new Park("City Park");
        park.addAttraction("Ferris Wheel", "10:00 - 20:00", 2000);
        park.addAttraction("Roller Coaster", "11:00 - 21:00", 3000);
        park.displayAttractions();
    }
}