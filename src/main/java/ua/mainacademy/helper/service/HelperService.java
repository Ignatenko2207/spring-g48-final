package ua.mainacademy.helper.service;

import ua.mainacademy.helper.UserHelper;

import java.util.*;
import java.util.stream.Collectors;

public class HelperService {

    public static List<UserHelper> getSortedList (List<UserHelper> collection){
        LinkedList<UserHelper> result = new LinkedList<>();

        Comparator<UserHelper> comparator = new Comparator<UserHelper>() {
            @Override
            public int compare(UserHelper o1, UserHelper o2) {
                int res = o1.getLastName().compareTo(o2.getLastName());
                if (res == 0) {
                    res = o1.getFirstName().compareTo(o2.getFirstName());
                    if (res == 0) {
                        res = o1.getMidName().compareTo(o2.getMidName());
                        if (res == 0) {
                            return o1.getAge() - o2.getAge();
                        }
                    }
                }
                return res;
            }
        };

        /// 1 variant
        LinkedList<UserHelper> finalResult = result;
        collection
                .stream()
                .sorted((o1, o2) -> comparator.compare(o1, o2))
                .forEach(it -> finalResult.add(it));

        /// 2 variant
        Collections.sort(finalResult);

        return result;
    }
}
