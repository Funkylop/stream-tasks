package task5;

import java.util.*;

public class Main {
    public static void main(
            String... args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person(1L, "Lokesh", new Skill("English", 10), new Skill("Kannada", 20), new Skill("Hindi", 10)));

        persons.add(new Person(2L, "Mahesh", new Skill("English", 10), new Skill("Kannada", 30), new Skill("Hindi", 50)));

        persons.add(new Person(3L, "Ganesh", new Skill("English", 100), new Skill("Kannada", 20), new Skill("Hindi", 40)));

        persons.add(new Person(4L, "Ramesh", new Skill("English", 10), new Skill("Kannada", 40), new Skill("Hindi", 40)));

        persons.add(new Person(5L, "Suresh", new Skill("English", 10), new Skill("Kannada", 40), new Skill("Hindi", 40)));

        persons.add(new Person(6L, "Gnanesh", new Skill("English", 100), new Skill("Kannada", 20), new Skill("Hindi", 40)));


        System.out.println(findBestMatchingPerson(persons, new Skill("English", 50),
                new Skill("Kannada", 50), new Skill("Urdu", 50),
                new Skill("Hindi", 50), new Skill("Russian", 50)));
        //OutPut: ["English" : "Gnanesh", "Kannada" : "Suresh", "Urdu": null, "Hindi": "Mahesh"]
    }

    public static HashMap<String, String> findBestMatchingPerson(List<Person> persons, Skill... skills) {
        HashMap<String, String> personSk = new HashMap<>();
        Arrays.asList(skills).forEach(skill -> {
            HashMap<Person, Skill> personSkills = new HashMap<>();
            persons.forEach(person -> {
                List<Skill> skillList = person.getSkills()
                        .stream()
                        .filter(personSkill -> personSkill.getName().equals(skill.getName())).toList();
                if (skillList.size() != 0) {
                    personSkills.put(person, person.getSkills()
                            .stream()
                            .filter(personSkill -> personSkill.getName().equals(skill.getName())).toList().get(0));
                } else personSk.put(skill.getName(), null);
            });
            List<Map.Entry<Person, Skill>> list1 = new ArrayList<>(personSkills.entrySet());
            list1.sort(Map.Entry.comparingByValue(Comparator.comparing(Skill::getKnownPercentage).reversed()));
            list1.forEach(map -> {
                final int[] i = {0};
                if (personSk.size() != 0) {
                    personSk.forEach((key, value) -> {
                        if (value != null) {
                            if (list1.size() != 0) {
                                while (value.equals(list1.get(i[0]).getKey())) {
                                    i[0]++;
                                }
                            }
                        }
                    });
                }
                if (personSk.get(skill.getName()) == null)
                    personSk.put(skill.getName(), list1.get(i[0]).getKey().getName());
            });
        });
        System.out.println(personSk);
        return personSk;
    }
}