package ecse489.group18.experiment3;

/**
 * The custom protocol message.
 * 
 * @author Jean-Sebastien Dery
 * @author Matthew McAllister
 * 
 */
public class Message {
	/**
	 * The message type of the current message.
	 */
	private MessageType messageType;
	/**
	 * The Sub-Message type of the current message.
	 */
	private int subMessageType;
	/**
	 * The size of the message data (payload) of the current message.
	 */
	private int size;
	/**
	 * The payload of the message.
	 */
	private String messageData;

	/**
	 * Factory for the messages.
	 * 
	 * @param defaultMessage
	 *            The type of message to be instantiated.
	 * @return The instantiated message.
	 */
	static public Message MessageFactory(DefaultMessages defaultMessage) {
		switch (defaultMessage) {
		case EXIT:
			return (new Message(MessageType.EXIT, 0, 0, ""));
		case ECHO:
			return (new Message(MessageType.ECHO, 0, 4, "ECHO"));
		case LOGOFF:
			return (new Message(MessageType.LOGOFF, 0, 0, ""));
		case DELETE_USER:
			return (new Message(MessageType.DELETE_USER, 0, 0, ""));
		case CREATE_STORE:
			return (new Message(MessageType.CREATE_STORE, 0, 0, ""));
		case QUERY_MESSAGES:
			return (new Message(MessageType.QUERY_MESSAGES, 0, 0, ""));
		}

		return (null);
	}

	public Message(MessageType messageType, int subMessageType, int size,
			String messageData) {
		this.messageType = messageType;
		this.subMessageType = subMessageType;
		this.size = size;
		this.messageData = messageData;
	}
}
