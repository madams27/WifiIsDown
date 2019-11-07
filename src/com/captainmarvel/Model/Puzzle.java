import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Puzzle 
{
	private String puzzleID;
	private String puzzleName;
	private String puzzleDescription;
	private String puzzleHint;
	
	//Getter method for variable puzzleID
	public String getPuzzleID() 
	{
		return puzzleID;
	}
	
	//Setter method for variable puzzleID
	public void setPuzzleID(String puzzleID) 
	{
		this.puzzleID = puzzleID;
	}
	
	//Getter method for variable puzzleName
	public String getPuzzleName() 
	{
		return puzzleName;
	}
	
	//Setter method for variable puzzleName
	public void setPuzzleName(String puzzleName) 
	{
		this.puzzleName = puzzleName;
	}
	
	//Getter method for variable puzzleDescription
	public String getPuzzleDescription() 
	{
		return puzzleDescription;
	}
	
	//Setter method for variable puzzleDescription
	public void setPuzzleDescription(String puzzleDescription) 
	{
		this.puzzleDescription = puzzleDescription;
	}
	
	//Getter method for variable puzzleHint
	public String getPuzzleHint() 
	{
		return puzzleHint;
	}
	
	//Setter method for variable puzzleHint
	public void setPuzzleHint(String puzzleHint) 
	{
		this.puzzleHint = puzzleHint;
	}
	
	//Method Reads Puzzle XML file
	public void readPuzzleXML()
	{
		File xml = new File("Puzzle.xml");
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b;
		try {
			b = f.newDocumentBuilder();
			Document d = b.parse(xml);
			d.getDocumentElement();
			NodeList puzzleNodes = d.getElementsByTagName("puzzle");
			for(int i = 0; i < puzzleNodes.getLength(); i++)
			{
				Node puzzleNode = puzzleNodes.item(i);
				if(puzzleNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element puzzleElement = (Element) puzzleNode;
					NodeList textNodes = puzzleElement.getElementsByTagName("name");
					
					//System.out.println(puzzleElement.getElementsByTagName("description").item(0).getTextContent());
					
					if(textNodes.getLength() > 0)
					{
						if(textNodes.item(0).getTextContent().equalsIgnoreCase("Dark Blue Puzzle"))
						{	
							//Ask user for next answer
							Scanner input = new Scanner(System.in);

							System.out.println("\nThere is a puzzle in the room."
									+ "\nType the command \"Examine\" to examine puzzle.");
							System.out.print("\n-> ");
							String command = input.nextLine();

							System.out.println("\n" + puzzleElement.getElementsByTagName(command.toLowerCase()).item(0).getTextContent());
							System.out.println("\n" + puzzleElement.getElementsByTagName("solve").item(0).getTextContent());

							int attempt = 0;

							do{
								attempt++;
								
								System.out.print("\n-> ");
								String answer = input.nextLine();
								
								String solution = puzzleElement.getElementsByTagName("answer").item(0).getTextContent();
								if(solution.equalsIgnoreCase(answer))
								{
									System.out.println("\nCongrats!! You solved the puzzle.\n");
									attempt = 3;
									
									System.out.println("\nChoose a direction: \n-> ");
									String direction = input.nextLine();
									
									Rooms r = new Rooms();
									r.readRoomsXML("id", puzzleElement.getElementsByTagName(direction).item(0).getTextContent());
								}
								else
								{
									int attempts = 3 - attempt;
									System.out.println("\nYou have " + attempts + " attempts left.");
								}
							}while(attempt != 3);
						}
					}
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println("\nWrong Input. Try Again.\n");
			readPuzzleXML();
		}
	}
}
