package gui;
import java.awt.event.ActionEvent;
import java.util.EventListener;

public interface FormListener extends EventListener  {
	public void formEventOccurred(FormEvent e);
}
