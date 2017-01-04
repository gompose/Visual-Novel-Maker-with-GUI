public class Slide {

    //Instance Variables
    private String text;
    private String picture;
    private String sound;
    //Constructors

    public Slide() {
	text = "";
	picture = "";
	sound = "";

    }
    public Slide(String _text, String _picture, String _sound) {
	text = _text;
	picture = _picture;
	sound = _sound;

    }
    //Accessor Methods

    public String getText() {
	return text;
    }
    public String getPicture() {
	return picture;
    }
    public String getSound() {
	return sound;
    }


    //Mutator Methods

    public void setText(String _text) {
	text = _text;
    }

    public void setPicture(String _picture) {
	picture = _picture;
    }

    public void setSound(String _sound) {
	sound = _sound;
    }



}
