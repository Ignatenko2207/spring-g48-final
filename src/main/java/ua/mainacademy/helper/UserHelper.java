package ua.mainacademy.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHelper implements Comparable<UserHelper>{

    private String lastName;
    private String firstName;
    private String midName;

    private Integer age;

    @Override
    public int compareTo(UserHelper userHelper) {
        int res = lastName.compareTo(userHelper.lastName);
        if (res == 0) {
            res = firstName.compareTo(userHelper.getFirstName());
            if (res == 0) {
                res = midName.compareTo(userHelper.getMidName());
                if (res == 0) {
                    return age - userHelper.getAge();
                }
            }
        }
        return res;
    }
}
