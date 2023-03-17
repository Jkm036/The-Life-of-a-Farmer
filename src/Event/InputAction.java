package Event;
import java.awt.event.KeyEvent;
public class InputAction extends Action {
int keycode;
	InputAction(int keycode){
		super(calctype(keycode));
		this.keycode=keycode;
	}
	public static Type calctype(int key) {
		switch (key) {
		case KeyEvent.VK_W:
			return Action.Type.UP;
		case KeyEvent.VK_A:
			return Action.Type.LEFT;
		case KeyEvent.VK_S:
			return Action.Type.DOWN;
		case KeyEvent.VK_D:
			return Action.Type.RIGHT;
		default:
			return Action.Type.UP;
			
		}
	}
}
