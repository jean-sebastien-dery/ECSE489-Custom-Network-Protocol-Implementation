package ecse489.group18.experiment3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Jean-Sebastien Dery
 * @author Matthew McAllister
 * 
 */
public class AppExitState extends AppState {

	/**
	 * @param backPointerApp
	 * @param socketInputStream
	 * @param socketOutputStream
	 * @param bufferedReader
	 */
	public AppExitState(App backPointerApp, BufferedInputStream bufferedInputStream,
			OutputStream socketOutputStream, BufferedReader bufferedReader) {
		super(backPointerApp, bufferedInputStream, socketOutputStream,
				bufferedReader);
	}

	@Override
	public void execute() {
		Helpers.printHeader("Exiting the application!");
		try {
			// This will ensure that only one thread at a time can send requests and retrieve the associated responses.
			synchronized(App.LOCK) {
				this.sendMessage(Message.MessageFactory(DefaultMessages.EXIT));
			}
			this.backPointerApp.stopPollingMessages();
			System.out.println("The connection with the server was closed.");
			this.pressEnterToContinue();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
