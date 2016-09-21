package ir.cdesign.planner.model;

import java.util.ArrayList;

import ir.cdesign.planner.R;

/**
 * Created by amin pc on 13/09/2016.
 */
public class categories {

    int ImageId;
    String Title;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public static ArrayList<categories> getData(){

        ArrayList<categories> dataList = new ArrayList<>();
        int[] images = getImages();
        String[] titles = getTitles();
        for (int i = 0 ; i <images.length ; i++){
            categories cat = new categories();
            cat.setImageId(images[i]);
            cat.setTitle(titles[i]);
            dataList.add(cat);
        }

        return dataList;
    }

    private static int[] getImages(){
        int[] getImages = new int[]{
            R.drawable.blinds , R.drawable.book ,
                R.drawable.cart ,
                R.drawable.food , R.drawable.home ,
                R.drawable.reproduction , R.drawable.school ,
                R.drawable.settings , R.drawable.target ,
                R.drawable.autofix , R.drawable.binoculars ,
                R.drawable.boombox , R.drawable.signal ,
                R.drawable.weight , R.drawable.cake ,
                R.drawable.tie , R.drawable.steering ,
                R.drawable.sleep , R.drawable.pen
        };
        return getImages;
    }

    private static String[] getTitles(){
        String[] getTitles = new String[]{
                "Movies","Reading","Shopping",
                "FastFood","Home","Reproduction",
                "University","Fixing","Zooming",
                "CoolStuff","Spying","Music",
                "Online","WorkOut","Birthday",
                "Party","Driving","Sleep",
                "Writing"
        };
        return getTitles;
    }



}
