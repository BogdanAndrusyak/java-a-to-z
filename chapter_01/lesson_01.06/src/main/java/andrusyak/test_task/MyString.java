package andrusyak.test_task;

public class MyString {

    boolean contains(String origin, String sub) {
        boolean contain = false;

        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();

        int j = 0;
        int count = 0;

        for (int i = 0; i < subArray.length; i++) {
            while(j < originArray.length) {
                if(subArray[i] == originArray[j]) {
                    count++;
                    j++;
                    break;
                } else {
                    count = 0;
                    j++;
                }
            }
        }

        if (count == subArray.length)
            contain = true;

        return contain;
    }
}
