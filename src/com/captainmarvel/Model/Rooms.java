import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Rooms 
{
	private String roomID;
	private String roomName;
	private String roomDescription;
	private String roomVisited;
	private String textNodeName;
	private String textNodeValue;
	//Ask user for next direction
	Scanner input = new Scanner(System.in);
	
	//constructor with no parameters
	Rooms()
	{
		
	}
	
	//Getter method for variable roomID
	public String getRoomID() 
	{
		return roomID;
	}
	
	//Setter method for variable roomID
	public void setRoomID(String roomID) 
	{
		this.roomID = roomID;
	}
	
	//Getter method for variable roomName
	public String getRoomName() 
	{
		return roomName;
	}
	
	//Setter method for variable roomName
	public void setRoomName(String roomName) 
	{
		this.roomName = roomName;
	}
	
	//Getter method for variable roomDescription
	public String getRoomDescription() 
	{
		return roomDescription;
	}
	
	//Setter method for variable roomDescription
	public void setRoomDescription(String roomDescription) 
	{
		this.roomDescription = roomDescription;
	}
	
	//Getter method for variable roomVisited
	public String getRoomVisited() {
		return roomVisited;
	}

	//Setter method for variable roomVisited
	public void setRoomVisited(String roomVisited) {
		this.roomVisited = roomVisited;
	}
	
	//Method reads Rooms XML file
	public void readRoomsXML(String textNodeName, String textNodeValue)
	{
		File xml = new File("Rooms.xml");
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b;
		try {
			b = f.newDocumentBuilder();
			Document d = b.parse(xml);
			d.getDocumentElement();
			NodeList roomNodes = d.getElementsByTagName("Room");
			for(int i = 0; i < roomNodes.getLength(); i++)
			{
				Node roomNode = roomNodes.item(i);
				if(roomNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element roomElement = (Element) roomNode;
					NodeList textNodes = roomElement.getElementsByTagName(textNodeName);
					
					if(textNodes.getLength() > 0)
					{
						if(textNodes.item(0).getTextContent().equalsIgnoreCase(textNodeValue))
						{	
							System.out.println(roomElement.getElementsByTagName("description").item(0).getTextContent());
							
							setRoomID(roomElement.getElementsByTagName("id").item(0).getTextContent());
							
							setRoomVisited(roomElement.getElementsByTagName("visited").item(0).getTextContent());
							
							changeRoom(d);
						}
					}
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println("\nWrong Input. Try Again.\n");
			readRoomsXML(textNodeName, textNodeValue);
		}
	}
	
	//Method to change rooms
	public void changeRoom(Document d)
	{
		NodeList roomNodes = d.getElementsByTagName("Room");
		for(int i = 0; i < roomNodes.getLength(); i++)
		{
			Node roomNode = roomNodes.item(i);
			if(roomNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element roomElement = (Element) roomNode;
				NodeList textNodes = roomElement.getElementsByTagName(textNodeName);
				
				if(textNodes.getLength() > 0)
				{
					if(textNodes.item(0).getTextContent().equalsIgnoreCase(textNodeValue))
					{	
						System.out.print("\n-> ");
						String roomNum = input.nextLine();
						//The statement print out the tag name information
						String n =roomElement.getElementsByTagName(roomNum.toUpperCase()).item(0).getTextContent();

						//print directions by attribute and value
						System.out.print("\n");
						readRoomsXML("id", n);
					}
				}
			}
		}
	}
	
	//Method to change rooms
	public void vRoom(Document d)
	{
		NodeList roomNodes = d.getElementsByTagName("Room");
		for(int i = 0; i < roomNodes.getLength(); i++)
		{
			Node roomNode = roomNodes.item(i);
			if(roomNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element roomElement = (Element) roomNode;
				NodeList textNodes = roomElement.getElementsByTagName(textNodeName);
				
				if(textNodes.getLength() > 0)
				{
					if(textNodes.item(0).getTextContent().equalsIgnoreCase(textNodeValue))
					{	
						
					}
				}
			}
		}
	}
	//Method changes XML file when room is visited
	public void visitedRoom(Document d)
	{
		Node rootNode = d.getFirstChild();
		
		Node elementNode = d.getElementsByTagName("Room").item(0);
		
		NodeList childNode = elementNode.getChildNodes();
		
		for(int i = 0; i < childNode.getLength(); i++)
		{
			Node node = childNode.item(i);
			
			if("visited".equals(node.getNodeName()))
			{
				node.setTextContent("true");
			}
		}
	}
}
