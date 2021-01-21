import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class MyObject {
    public static void main(String[] args) {
        //Skapar 50 objekt med random värde för value, bool and name
        repeater(50);

        //Skapar en ArrayList enbart med objekt där 'value'>20
        List<Person> myList = classArrayList;
        List<Person> listValueOver20 = myList
                .stream()
                .filter(x -> x.getValue() <= 20)
                .collect(Collectors.toList());
        System.out.println("Objekt med 'value' över 20: " + listValueOver20.size());
        System.out.println();

        //beräkna medelvärdet på 'value'
        List<Person> valueList = new ArrayList<>(classArrayList);
        OptionalDouble averageValue = valueList
                .stream()
                .map(Person::getValue)
                .mapToDouble(a -> a)
                .average();
        if (averageValue.isPresent()) {
            double average = averageValue.getAsDouble();
            System.out.println("Medelvärde av 'value' är: " + average);
            System.out.println();
        }

        //Byter ut 'name' till 'this is true' för alla object med bool==true. Sparas i ifTrueChangeName
        List<Person> ifTrueChangeName = new ArrayList<>(classArrayList);
        ifTrueChangeName
                .stream()
                .map(x -> {
                    if (x.getBool()) {
                        x.setName("THIS IS TRUE");
                    }
                    return null;
                })
                .collect(Collectors.toList());
        //skriver ut ifTrueChangeName
        System.out.println("----- PRINTING LIST: 'ifTrueChangeName' -----");
        for (Person person : ifTrueChangeName) {
            System.out.println(person.getPosition() + " " +person.getBool() + " " + person.getValue() + " " + person.getName());
        }
        System.out.println("----- END OF PRINT -----");
    }
    static List<Person> classArrayList = new ArrayList<>();
    static class Person {
        int position;
        public int getPosition() {return position;}
        boolean bool;
        public boolean getBool() {return bool;}
        public void setBool(boolean newBool) {this.bool = newBool;}
        int value;
        public int getValue() {return value;}
        public void setValue(int newValue) {this.value = newValue;}
        String name;
        public String getName() {return name;}
        public void setName(String newName) {this.name = newName;}
    }
    static void methodM(int j) {
        Random randomno = new Random();
        Random randomno2 = new Random();
        boolean b;
        int i;
        String s;
        b = randomno.nextBoolean();
        i = 1 + (int) (Math.random() * ((50 - 1) + 1));
        int leftLimit = 97; //
        int rightLimit = 122; //
        int targetStringLength = 5;
        s = randomno2.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        Person person = new Person();
        person.position = j;
        person.bool = b;
        person.value = i;
        person.name = s;
        classArrayList.add(person);
    }
    static void repeater(int i) {
        int counter = 1;
        while (counter <= i) {
            methodM(counter);
            counter++;
        }
    }
}
