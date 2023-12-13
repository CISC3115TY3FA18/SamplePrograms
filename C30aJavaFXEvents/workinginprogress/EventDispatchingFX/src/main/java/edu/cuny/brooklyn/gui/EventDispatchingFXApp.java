package edu.cuny.brooklyn.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EventDispatchingFXApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox();
		Button[] buttons = new Button[5];
		for (int i=0; i<buttons.length; i++) {
			buttons[i] = new Button("Button " + i);
		}
		hbox.getChildren().addAll(buttons);
		Scene scene = new Scene(hbox, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		class TravelerEventDispatchChain implements EventDispatchChain {
			private Button[] buttons;
			private List<EventDispatcher> chain;
			private boolean[] handled;
			private int pos;
			
			public TravelerEventDispatchChain(Button[] buttons) {
				this.buttons = buttons;
				this.chain = new ArrayList<EventDispatcher>(buttons.length);
				this.handled = new boolean[buttons.length];
				for (int i=0; i<buttons.length; i++) {
					chain.add(buttons[i].getEventDispatcher());
					handled[i] = false;
				}
				pos = 0;
			}

			@Override
			public EventDispatchChain append(EventDispatcher dispatcher) {
				chain.add(dispatcher);
				return this;
			}

			@Override
			public Event dispatchEvent(Event event) {
				System.out.println("received event");
				return null;
			}

			@Override
			public EventDispatchChain prepend(EventDispatcher dispatcher) {
				chain.add(0, dispatcher);
				return this;
			}
			
		}
		
		
		buttons[0].setOnAction(e->{
			TravelerEvent event = new TravelerEvent(buttons[0], buttons[0]);
			TravelerEventDispatchChain chain = new TravelerEventDispatchChain(buttons);
			chain.dispatchEvent(e);
			// buttons[0].fireEvent(event);
		});
		
		buttons[0].addEventFilter(TravelerEvent.ANY, e->System.out.println("capturing: encountered a TravelerEvent"));
		buttons[0].addEventHandler(TravelerEvent.ANY, e->System.out.println("bubbling: encountered a TravelerEvent"));
	}
	

}
