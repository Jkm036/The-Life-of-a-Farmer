package Event;

public class Action {
int keycode;
public static enum Type{
	UP,
	DOWN,
	LEFT,
	RIGHT;
}
public Type type;
	Action(Type type){
		this.type=type;
	}

}
