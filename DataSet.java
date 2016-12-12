
public class DataSet {

    float rating[], age;
    int sex;

    public DataSet getDataSet(NormalizedUser user, int mode) {
        DataSet retDataSet = new DataSet();
        retDataSet.age = user.age;
        retDataSet.sex = user.sex;
        switch (mode) {
            case 0:
                // Normal data set
                retDataSet.rating = new float[25];
                System.arraycopy(user.rating, 0, retDataSet.rating, 0, 25);
                break;
            case 1:
                // training data set
                retDataSet.rating = new float[17];
                System.arraycopy(user.rating, 0, retDataSet.rating, 0, 17);
                break;
            case 2:
                retDataSet.rating = new float[8];
                for (int i = 0; i < 8; i++) {
                    retDataSet.rating[i] = user.rating[16 + i];
                }
                break;
            default:
                break;
        }
        return retDataSet;
    }
}
