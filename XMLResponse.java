package c1xml;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.io.FileWriter;
import java.io.BufferedWriter;
import javax.swing.JOptionPane;

public class XMLResponse {
	
	

	public static void create() {
		
		String fileNameTimeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
		String issueDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());	
		
		String newfileName = "InvoiceResponse-" + fileNameTimeStamp;
		
		// ParticipantID's
		String sSenderSchemeID = InputScreen.SenderSchemeID.getText();
		String sSenderNZBN = InputScreen.SenderNZBN.getText();		
		// String sSenderParticipantID = sSenderSchemeID + ":" + sSenderNZBN ;
		String sReceiverSchemeID = InputScreen.ReceiverSchemeID.getText();	
		String sReceiverNZBN = InputScreen.ReceiverNZBN.getText();		
		// String sReceiverParticipantID = sReceiverSchemeID + ":" + sReceiverNZBN;
		
		String supplierName = InputScreen.SupplierName.getText();
		String customerName = InputScreen.CustomerName.getText();
		
		// Buyer & PO Reference
		// Use one of the below for cac:DocumentReference / ID ???
		String buyerReference = InputScreen.BuyerReference.getText();
		String poReference = InputScreen.POReference.getText();
		
		////////////////////////////////////////////////////////
		//             Create the File                        //
		////////////////////////////////////////////////////////

		// Note: escape sequence  \"   - Inserts a double quote character in the text.
		try {
			FileWriter fstream = new FileWriter ("C:/e-Invoice/Corner1-XML-Generator/Output/Output.txt");                    
			BufferedWriter info = new BufferedWriter(fstream);
			
			info.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    		info.newLine();
    		info.write("<ApplicationResponse xmlns:cac=\"urn:oasis:names:specification:ubl:schema:xsd:ApplicationResponse-2\"");
    		info.newLine();
    		info.write("        xmlns:cbc=\"urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2\"");
    		info.newLine();
    		info.write("        xmlns=\"urn:oasis:names:specification:ubl:schema:xsd:ApplicationResponse-2\">");
    		info.newLine();
    		info.write("    <cbc:UBLVersionID>2.1</cbc:UBLVersionID>");
    		info.newLine();	 
    		info.write("    <cbc:CustomizationID>urn:www.peppol.eu:transaction:biitrns111:ver1.0</cbc:CustomizationID>");
    		info.newLine();	
    		info.write("    <cbc:ProfileID>urn:www.peppol.eu:profile:bis63a:ver1.0</cbc:ProfileID>");
    		info.newLine();
    		info.write("    <cbc:ID>" + XMLFile.sUUID + "</cbc:ID>");  		
    		info.newLine();
    		info.write("    <cbc:IssueDate>" + issueDate + "</cbc:IssueDate>");
    		info.newLine();
    		info.write("    <cac:SenderParty>");
    		info.newLine();
    		// Build the line for the endpoint as this is complex
	    	info.write("         <cbc:EndpointID schemeID=\"" + sSenderSchemeID + "\">" + sSenderNZBN + "</cbc:EndpointID>");
	    	info.newLine();	
    		info.write("        <cac:PartyName>");
    		info.newLine();
    		info.write("            <cbc:Name>" + supplierName + "</cbc:Name>");
    		info.newLine();
    		info.write("        </cac:PartyName>");
    		info.newLine();
    		info.write("    </cac:SenderParty>");
    		info.newLine();
    		info.write("    <cac:ReceiverParty>");
    		info.newLine();  		
    		// Build the line for the endpoint as this is complex
		    info.write("         <cbc:EndpointID schemeID=\"" + sReceiverSchemeID + "\">" + sReceiverNZBN + "</cbc:EndpointID>");
		    info.newLine();	
    		info.write("        <cac:PartyName>");
    		info.newLine();
    		info.write("        <cbc:Name>" + customerName + "</cbc:Name>");
    		info.newLine();
    		info.write("        </cac:PartyName>");
    		info.newLine();
    		info.write("    </cac:ReceiverParty>");
    		info.newLine();
    		info.write("    <cac:DocumentResponse>");
    		info.newLine();
    		info.write("        <cac:Response>");
    		info.newLine();
    		info.write("            <cbc:ResponseCode listID=\"UNCL4343OpSubset\">" + InputScreen.sResponseCode + "</cbc:ResponseCode>");
    		info.newLine();
    		if (InputScreen.sResponseCode.equals("RE")) {
    			info.write("            <cac:Status>");
        		info.newLine();
        		info.write("                <cbc:StatusReason>A textual explanation for why the invoice is being rejected</cbc:StatusReason>            ");
        		info.newLine();
        		info.write("            </cac:Status>");
        		info.newLine();
    		}
    		info.write("        </cac:Response>");
    		info.newLine();
    		info.write("           <cac:DocumentReference>");
    		info.newLine();
    		info.write("           <cbc:ID>" + buyerReference + "</cbc:ID>");             
    		info.newLine();
    		info.write("          <cbc:DocumentTypeCode listID=\"UNECE1001\">380</cbc:DocumentTypeCode>");
    		info.newLine();
    		info.write("       </cac:DocumentReference>");
    		info.newLine();
    		info.write("    </cac:DocumentResponse>");
    		info.newLine();
    		info.write("</ApplicationResponse>");
    		info.close();
    		// Now copy the output.txt file to a .XML file    		 		
    		File sourceFile = new File("C:/e-Invoice/Corner1-XML-Generator/Output/Output.txt");	    		
    		File destFile = new File("C:/e-Invoice/Corner1-XML-Generator/Output/"  + newfileName + ".xml");
    		 
    		if (sourceFile.renameTo(destFile)) {
    		    System.out.println("File renamed successfully");
    		} else {
    		    System.out.println("Failed to rename file");
    		}
    		
    		
			}
			catch(IOException e){
				e.printStackTrace();
			}
			
		} // end of try
	
		
	

}
