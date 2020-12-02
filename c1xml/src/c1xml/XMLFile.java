package c1xml;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
import java.io.FileWriter;
import java.io.BufferedWriter;
import javax.swing.JOptionPane;


public class XMLFile {
	
	public static void create() {
		
		String XMLtimeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
		String fileNameTimeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
		String issueDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());		

		// The new file needs a FILENAME which can identify it by type and date/time
		// initialize & debug		
		String newfileName = "notNamedProperly";		
		if (InputScreen.sMODE.equals("sPAYLOAD")) {
			newfileName = "InvoicePayload-" + fileNameTimeStamp;
 		}
 	   if (InputScreen.sMODE.equals("sFULLN2S")) {
 		  newfileName = "Invoice-N2S-" + fileNameTimeStamp;
 		}
 	   if (InputScreen.sMODE.equals("sFULLS2N")) {
 		  newfileName = "Invoice-S2N-" + fileNameTimeStamp;
 		}
		
		
		// Create a random UUID:
		UUID uuid1 = UUID.randomUUID();
		String sUUID = uuid1.toString();
		
		// Due date is 30 days from now
		// LocalDate today = LocalDate.now(); 
		// LocalDate dueDate = today.plusDays(30);	
		String dueDateString = InputScreen.InvoiceDueDate.getText();
		
		// Buyer & PO Reference
		String buyerReference = InputScreen.BuyerReference.getText();
		String poReference = InputScreen.POReference.getText();
			
		// Get Supplier name & address
		String supplierName = InputScreen.SupplierName.getText();
		String supplierAddress1 = InputScreen.SupplierAddress1.getText();
		String supplierAddress2 = InputScreen.SupplierAddress2.getText();
		String supplierCity = InputScreen.SupplierCity.getText();
		String supplierPostcode = InputScreen.SupplierPostcode.getText();
		String supplierCountryCode = InputScreen.SupplierCountryCode.getText();		
		
		// Get Customer name & address
		String customerName = InputScreen.CustomerName.getText();
		String customerAddress1 = InputScreen.CustomerAddress1.getText();
		String customerAddress2 = InputScreen.CustomerAddress2.getText();
		String customerCity = InputScreen.CustomerCity.getText();
		String customerPostcode = InputScreen.CustomerPostcode.getText();
		String customerCountryCode = InputScreen.CustomerCountryCode.getText();	
		
		// Get Invoice Lines
		String goodsDescription1 = InputScreen.GoodsDescription1.getText();
		String goodsDescription2 = InputScreen.GoodsDescription2.getText();
		String goodsDescription3 = InputScreen.GoodsDescription3.getText();
		
		// Get Supplier Contact Details
		String sSupplierContactName = InputScreen.SupplierContactName.getText();
		String sSupplierContactTelephone = InputScreen.SupplierContactTelephone.getText();
		String sSupplierContactEmail = InputScreen.SupplierContactEmail.getText();
		
		String quantity1 = InputScreen.Quantity1.getText();
		if(quantity1.isEmpty()) {
   			quantity1 = "0";
   	    }
		String quantity2 = InputScreen.Quantity2.getText();
		if(quantity2.isEmpty()) {
   			quantity2 = "0";
   	    }
		String quantity3 = InputScreen.Quantity3.getText();
		if(quantity3.isEmpty()) {
   			quantity3 = "0";
   	    }
		
		String baseAmount1 = InputScreen.BaseAmount1.getText();
		if(baseAmount1.isEmpty()) {
			baseAmount1 = "0.00";
   	    }
		String baseAmount2 = InputScreen.BaseAmount2.getText();
		if(baseAmount2.isEmpty()) {
			baseAmount2 = "0.00";
   	    }
		String baseAmount3 = InputScreen.BaseAmount3.getText();
		if(baseAmount3.isEmpty()) {
			baseAmount3 = "0.00";
   	    }
		
		String discount1 = InputScreen.Discount1.getText();
		if(discount1.isEmpty()) {
			discount1 = "0.00";
   	    }
		String discount2 = InputScreen.Discount2.getText();
		if(discount2.isEmpty()) {
			discount2 = "0.00";
   	    }
		String discount3 = InputScreen.Discount3.getText();
		if(discount3.isEmpty()) {
			discount3 = "0.00";
   	    }
		
		String priceAmount1 = InputScreen.PriceAmount1.getText();
		if(priceAmount1.isEmpty()) {
			priceAmount1 = "0.00";
   	    }
		String priceAmount2 = InputScreen.PriceAmount2.getText();
		if(priceAmount2.isEmpty()) {
			priceAmount2 = "0.00";
   	    }
		String priceAmount3 = InputScreen.PriceAmount3.getText();
		if(priceAmount3.isEmpty()) {
			priceAmount3 = "0.00";
   	    }
		
		String lineExtensionAmount1 = InputScreen.LineExtensionAmount1.getText();
		String lineExtensionAmount2 = InputScreen.LineExtensionAmount2.getText();
		String lineExtensionAmount3 = InputScreen.LineExtensionAmount3.getText();
		String lineExtensionAmountTotal = InputScreen.LineExtensionAmountTotal.getText();
		
		String sLineCharge1 = InputScreen.LineCharge1.getText();
		String sLineCharge2 = InputScreen.LineCharge2.getText();
		String sLineCharge3 = InputScreen.LineCharge3.getText();
			
		String allowanceChargeDescription = InputScreen.AllowanceChargeDescription.getText();
		
		String taxableAmount = InputScreen.TaxableAmount.getText();
		String taxAmount = InputScreen.TaxAmount.getText();
		String taxExclusiveAmount = InputScreen.TaxExclusiveAmount.getText();
		String taxInclusiveAmount = InputScreen.TaxInclusiveAmount.getText();
		
		String sAllowanceTotalAmount = InputScreen.AllowanceTotalAmount.getText();	
		String sChargeTotalAmount = InputScreen.ChargeTotalAmount.getText();
		
		String payableAmount = InputScreen.PayableAmount.getText();	
		
		// ParticipantID's
		String sSenderSchemeID = InputScreen.SenderSchemeID.getText();
   	    String sSenderNZBN = InputScreen.SenderNZBN.getText();		
   	    String sSenderParticipantID = sSenderSchemeID + ":" + sSenderNZBN ;
   		String sReceiverSchemeID = InputScreen.ReceiverSchemeID.getText();	
   	    String sReceiverNZBN = InputScreen.ReceiverNZBN.getText();		
   	    String sReceiverParticipantID = sReceiverSchemeID + ":" + sReceiverNZBN;
   	    
   	    // SWAP for S to N
 	    // For S to N need to swap:
 	    // Sender and Receiver
 	    // Supplier and Customer
 	    if (InputScreen.sMODE.equals("sFULLS2N")) {
 		   // define a temp string for the swap
 		   // Just swap the PEPPOL identifiers:
 		   String temp;
 		   
 		   temp = sSenderSchemeID;
 		   sSenderSchemeID = sReceiverSchemeID;
 		   sReceiverSchemeID = temp;
 		   
 		   temp = sSenderNZBN;
 		   sSenderNZBN = sReceiverNZBN;
 		   sReceiverNZBN = temp;
 		   
 		   temp = sSenderParticipantID;
 		   sSenderParticipantID = sReceiverParticipantID;
 		   sReceiverParticipantID = temp; 
 		   //
 		   temp = supplierName;
 		   supplierName = customerName;
 		   customerName = temp;
 		   //
 		   temp = supplierAddress1;
 		   supplierAddress1 = customerAddress1;
 		   customerAddress1 = temp;
 		   //
 		   temp = supplierAddress2;
 		   supplierAddress2 = customerAddress2;
 		   customerAddress2 = temp;
	       //
 	       temp = supplierCity;
 		   supplierCity = customerCity;
 		   customerCity = temp;
 		   //
 		   temp = supplierPostcode;
 		   supplierPostcode = customerPostcode;
 		   customerPostcode = temp;
 		}
 	    
 	    // Optional Fields
 	    String sSupplierTaxIdentifier = InputScreen.SupplierTaxIdentifier.getText();
 	    
 	    
 	    
		
		////////////////////////////////////////////////////////
		//             Create the File                        //
		////////////////////////////////////////////////////////
		
		// Note: escape sequence  \"   - Inserts a double quote character in the text.
		
    	try{  	
    		// Use sMODE to determine the filename and if SDBH is needed		
    		FileWriter fstream = new FileWriter ("C:/e-Invoice/Corner1-XML-Generator/Output/Output.txt");                    
    		BufferedWriter info = new BufferedWriter(fstream);
    		// Start Standard Business Document Header (SDBH)
    		if ((InputScreen.sMODE.equals("sFULLN2S")) || (InputScreen.sMODE.equals("sFULLS2N"))){
    			info.write("<StandardBusinessDocument xmlns=\"http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader\">");
        		info.newLine();
        		info.write("   <StandardBusinessDocumentHeader>");
        		info.newLine();
        		info.write("      <HeaderVersion>1.0</HeaderVersion>");
        		info.newLine();
        		info.write("      <Sender>");
        		info.newLine();	       		
        		info.write("         <Identifier Authority=\"iso6523-actorid-upis\">" + sSenderParticipantID + "</Identifier>");
        		info.newLine();       		
        		info.write("      </Sender>");
        		info.newLine();	
        		info.write("      <Receiver>");
        		info.newLine();	       		
        		info.write("         <Identifier Authority=\"iso6523-actorid-upis\">" + sReceiverParticipantID + "</Identifier>");
        		info.newLine();       		
        		info.write("      </Receiver>");
        		info.newLine();
        		info.write("      <DocumentIdentification>");
        		info.newLine();
        		info.write("         <Standard>urn:oasis:names:specification:ubl:schema:xsd:Invoice-2</Standard>");
        		info.newLine();
        		info.write("         <TypeVersion>2.1</TypeVersion>");
        		info.newLine();
        		info.write("         <InstanceIdentifier>" + sUUID + "</InstanceIdentifier>");
        		info.newLine();	
        		info.write("         <Type>Invoice</Type>");
        		info.newLine();
        		info.write("         <CreationDateAndTime>" + XMLtimeStamp + "</CreationDateAndTime>");
        		info.newLine();	
        		info.write("      </DocumentIdentification>");
        		info.newLine();
        		info.write("      <BusinessScope>");
        		info.newLine();	
        		info.write("         <Scope>");
        		info.newLine();
        		info.write("            <Type>DOCUMENTID</Type>");
        		info.newLine();
        		info.write("            <InstanceIdentifier>urn:oasis:names:specification:ubl:schema:xsd:Invoice-2::Invoice##urn:cen.eu:en16931:2017#conformant#urn:fdc:peppol.eu:2017:poacc:billing:international:aunz:3.0::2.1</InstanceIdentifier>"); 
        		info.newLine();	
        		info.write("            <Identifier>busdox-docid-qns</Identifier>"); 
          		info.newLine();	
        		info.write("         </Scope>");
        		info.newLine();	
        		info.write("         <Scope>");
        		info.newLine();
        		info.write("            <Type>PROCESSID</Type>");
        		info.newLine();
        		info.write("            <InstanceIdentifier>urn:fdc:peppol.eu:2017:poacc:billing:01:1.0</InstanceIdentifier>");
        		info.newLine();	
        		info.write("            <Identifier>cenbii-procid-ubl</Identifier>");       		
        		info.newLine();	
        		info.write("         </Scope>");        		
        		info.newLine();	
        		info.write("      </BusinessScope>");
        		info.newLine();	
        		info.write("   </StandardBusinessDocumentHeader>");
        		info.newLine();	
    		}  		
    		// Start XML Payload
    		if (InputScreen.sMODE.equals("sPAYLOAD")) {
    			// printed for payload only
    			info.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        		info.newLine();
     		}
    		info.write("<Invoice xmlns:cac=\"urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2\"");
    		info.newLine();
    		info.write("         xmlns:cbc=\"urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2\"");
    		info.newLine();	    
    		info.write("         xmlns=\"urn:oasis:names:specification:ubl:schema:xsd:Invoice-2\">");
    		info.newLine();
    		info.write("   <cbc:CustomizationID>urn:cen.eu:en16931:2017#conformant#urn:fdc:peppol.eu:2017:poacc:billing:international:aunz:3.0</cbc:CustomizationID>");
    		info.newLine();
    		info.write("   <cbc:ProfileID>urn:fdc:peppol.eu:2017:poacc:billing:01:1.0</cbc:ProfileID>");
    		info.newLine();
    		info.write("   <cbc:ID>"+sUUID+"</cbc:ID>");
    		info.newLine();  		
    		info.write("   <cbc:IssueDate>"+issueDate+"</cbc:IssueDate>");
    		info.newLine();
    		info.write("   <cbc:DueDate>"+dueDateString+"</cbc:DueDate>");
    		info.newLine();
    		info.write("   <cbc:InvoiceTypeCode>380</cbc:InvoiceTypeCode>");
    		info.newLine();
    		String sCurrencyCode = InputScreen.sCurrencyID;  // used in other places
    		info.write("   <cbc:DocumentCurrencyCode>" + sCurrencyCode + "</cbc:DocumentCurrencyCode>");
    		info.newLine();
    		if (buyerReference.length() > 0) {
    		   info.write("   <cbc:BuyerReference>"+buyerReference+"</cbc:BuyerReference>");
    		   info.newLine();}
    		if (poReference.length() > 0) {
    			info.write("   <cac:OrderReference>");
    			info.newLine();
    			info.write("      <cbc:ID>" + poReference + "</cbc:ID>");
    			info.newLine();
    			info.write("   </cac:OrderReference>");
     		    info.newLine();}
    		
            // START Accounting Supplier Party
    		info.write("   <cac:AccountingSupplierParty>");
			info.newLine();
		    info.write("      <cac:Party>");
			info.newLine();				
			// Build the line for the endpoint as this is complex
		    	info.write("         <cbc:EndpointID schemeID=\"" + sSenderSchemeID + "\">" + sSenderNZBN + "</cbc:EndpointID>");
		    	info.newLine();	
		    info.write("         <cac:PartyIdentification>");	
		    info.newLine();	
		    info.write("            <cbc:ID>" + sSenderNZBN + "</cbc:ID>");	
		    info.newLine();
		    info.write("         </cac:PartyIdentification>");	
		    info.newLine();	
		    info.write("         <cac:PartyName>");	
			info.newLine();	   
			info.write("            <cbc:Name>" + supplierName + "</cbc:Name>");	
			info.newLine();
			info.write("         </cac:PartyName>");	
			info.newLine();
			info.write("         <cac:PostalAddress>");	
			info.newLine();
			info.write("            <cbc:StreetName>" + supplierAddress1 + "</cbc:StreetName>");	
			info.newLine();		
			if (supplierAddress2.length() > 0) {
				info.write("            <cbc:AdditionalStreetName>" + supplierAddress2 + "</cbc:AdditionalStreetName>");
	    		info.newLine();}						
			info.write("            <cbc:CityName>" + supplierCity + "</cbc:CityName>");	
			info.newLine();
			info.write("            <cbc:PostalZone>" + supplierPostcode + "</cbc:PostalZone>");	
			info.newLine();
			info.write("            <cac:Country>");
			info.newLine();
			info.write("               <cbc:IdentificationCode>" + supplierCountryCode + "</cbc:IdentificationCode>");
			info.newLine();
			info.write("            </cac:Country>");
 		    info.newLine(); 
			
 		    info.write("         </cac:PostalAddress>");
			// Optional Field - Supplier Tax Identifier
			if (sSupplierTaxIdentifier.length() > 0) {
				info.write("         <cac:PartyTaxScheme>");	
				info.newLine();
				info.write("            <cbc:CompanyID>" + sSupplierTaxIdentifier + "</cbc:CompanyID>");	
				info.newLine();
				info.write("            <cac:TaxScheme>");	
				info.newLine();
				info.write("                <cbc:ID>GST</cbc:ID>");	
				info.newLine();			
				info.write("            </cac:TaxScheme>");	
				info.newLine();
				info.write("         </cac:PartyTaxScheme>");	
				info.newLine();
			}
			info.newLine();				
			info.write("         <cac:PartyLegalEntity>");	
		    info.newLine();	
		    info.write("            <cbc:RegistrationName>" + supplierName + "</cbc:RegistrationName>");	
		    info.newLine();
		    // Build the line for the CompanyID - Same structure as EndpointID
	    	info.write("            <cbc:CompanyID schemeID=\"" + sSenderSchemeID + "\">" + sSenderNZBN + "</cbc:CompanyID>");
	    	info.newLine();	
		    info.write("         </cac:PartyLegalEntity>");	
		    info.newLine();	
		    // Optional Fields - Supplier Contact Details
		    int iContactCounter = sSupplierContactName.length() + sSupplierContactTelephone.length() + sSupplierContactEmail.length();
		    if (iContactCounter > 0) {
		    	info.write("         <cac:Contact>");
		    	info.newLine();	
		    	 if (sSupplierContactName.length() > 0) {
			    	 info.write("         <cbc:Name>" + sSupplierContactName + "</cbc:Name>");
			    	 info.newLine();	
			    }
			    if (sSupplierContactTelephone.length() > 0) {
			    	 info.write("         <cbc:Telephone>" + sSupplierContactTelephone + "</cbc:Telephone>");
			    	 info.newLine();	
			    }
			    if (sSupplierContactEmail.length() > 0) {
			    	 info.write("         <cbc:ElectronicMail>" + sSupplierContactEmail + "</cbc:ElectronicMail>");
			    	 info.newLine();	
			    }

		    	info.write("         </cac:Contact>");
		    	info.newLine();	
		    }  // end of Optional Fields - Supplier Contact Details
		    	
			info.write("      </cac:Party>");
			info.newLine();			
			info.write("   </cac:AccountingSupplierParty>");
			info.newLine();
			// END Accounting Supplier Party
    		
			// START Accounting Customer Party
    		info.write("   <cac:AccountingCustomerParty>");
			info.newLine();
		    info.write("      <cac:Party>");
			info.newLine();				
			// Build the line for the endpoint as this is complex
		    info.write("         <cbc:EndpointID schemeID=\"" + sReceiverSchemeID + "\">" + sReceiverNZBN + "</cbc:EndpointID>");
		    info.newLine();	
		    info.write("         <cac:PartyIdentification>");	
		    info.newLine();	
		    info.write("            <cbc:ID>" + sReceiverNZBN + "</cbc:ID>");	
		    info.newLine();
		    info.write("         </cac:PartyIdentification>");	
		    info.newLine();	
		    info.write("         <cac:PartyName>");	
			info.newLine();	   
			info.write("            <cbc:Name>" + customerName + "</cbc:Name>");	
			info.newLine();
			info.write("         </cac:PartyName>");	
			info.newLine();
			info.write("         <cac:PostalAddress>");	
			info.newLine();
			info.write("            <cbc:StreetName>" + customerAddress1 + "</cbc:StreetName>");	
			info.newLine();		
			if (supplierAddress2.length() > 0) {
				info.write("            <cbc:AdditionalStreetName>" + customerAddress2 + "</cbc:AdditionalStreetName>");
	    		info.newLine();}						
			info.write("            <cbc:CityName>" + customerCity + "</cbc:CityName>");	
			info.newLine();
			info.write("            <cbc:PostalZone>" + customerPostcode + "</cbc:PostalZone>");	
			info.newLine();
			info.write("            <cac:Country>");
			info.newLine();
			info.write("               <cbc:IdentificationCode>" + customerCountryCode + "</cbc:IdentificationCode>");
			info.newLine();
			info.write("            </cac:Country>");
 		    info.newLine(); 
			info.write("         </cac:PostalAddress>");	
			info.newLine();				
			info.write("         <cac:PartyLegalEntity>");	
		    info.newLine();	
		    info.write("            <cbc:RegistrationName>" + customerName + "</cbc:RegistrationName>");	
		    info.newLine();
		    // Build the line for the CompanyID - Same structure as EndpointID
	    	info.write("            <cbc:CompanyID schemeID=\"" + sReceiverSchemeID + "\">" + sReceiverNZBN + "</cbc:CompanyID>");
	    	info.newLine();	
		    info.write("         </cac:PartyLegalEntity>");	
		    info.newLine();	
			info.write("      </cac:Party>");
			info.newLine();			
			info.write("   </cac:AccountingCustomerParty>");
			info.newLine();
			// END Accounting Customer Party
			
			// Payment Means
			String SPaymentMeansAccount = InputScreen.PaymentMeansAccount.getText();
			String SPaymentMeansName = InputScreen.PaymentMeansName.getText();
			String sCustomerName = InputScreen.CustomerName.getText();
			// Credit Transfer
			if (InputScreen.sPaymentMeansCode.equals("30")) {
				info.write("   <cac:PaymentMeans>");
				info.newLine();
				info.write("      <cbc:PaymentMeansCode>30</cbc:PaymentMeansCode>");
				info.newLine();
				info.write("      <cac:PayeeFinancialAccount>");
				info.newLine();
				info.write("         <cbc:ID>" + SPaymentMeansAccount + "</cbc:ID>");
				info.newLine();
				info.write("         <cbc:Name>" + SPaymentMeansName + "</cbc:Name>");
				info.newLine();
				info.write("      </cac:PayeeFinancialAccount>");
				info.newLine();
				info.write("   </cac:PaymentMeans>");
				info.newLine();
			} else if (InputScreen.sPaymentMeansCode.equals("49")) {
				// Direct Debit
				info.write("   <cac:PaymentMeans>");
				info.newLine();
				info.write("      <cbc:PaymentMeansCode>49</cbc:PaymentMeansCode>");
				info.newLine();
				info.write("      <cac:PaymentMandate>");
				info.newLine();
				info.write("         <cbc:ID>" + SPaymentMeansAccount + "</cbc:ID>");
				info.newLine();
				info.write("         <cac:PayerFinancialAccount>");
				info.newLine();	
				info.write("            <cbc:ID>" + sCustomerName + "</cbc:ID>");
				info.newLine();
				info.write("         </cac:PayerFinancialAccount>");
				info.newLine();	
				info.newLine();
				info.write("      </cac:PaymentMandate>");
				info.newLine();
				info.write("   </cac:PaymentMeans>");
				info.newLine();
			} else if (InputScreen.sPaymentMeansCode.equals("68")) {
				// Online Payment Service
				info.write("   <cac:PaymentMeans>");
				info.newLine();
				info.write("      <cbc:PaymentMeansCode>68</cbc:PaymentMeansCode>");
				info.newLine();
				info.write("      <cbc:PaymentID>" + SPaymentMeansName + "</cbc:PaymentID>");
				info.newLine();
				info.write("   </cac:PaymentMeans>");
				info.newLine();
			}
			// End Payment Means
			
    		// START Invoice Level Allowance / Charge
			// Invoice Level Allowance	(print if not equal to 0.00)
			if (sAllowanceTotalAmount.equals("0.00")) {
				// do nothing
			} else {
				// print this xml section
				info.write("   <cac:AllowanceCharge>");
				info.newLine();
				info.write("      <cbc:ChargeIndicator>false</cbc:ChargeIndicator>");
				info.newLine();
				info.write("      <cbc:AllowanceChargeReason>" + allowanceChargeDescription + "</cbc:AllowanceChargeReason>");
				info.newLine();
				info.write("      <cbc:Amount currencyID=\"" + sCurrencyCode + "\">" + sAllowanceTotalAmount + "</cbc:Amount>");
				info.newLine();
				info.write("      <cac:TaxCategory>");
				info.newLine();
				info.write("         <cbc:ID>"+ InputScreen.sTaxCategoryID +"</cbc:ID>");
				info.newLine();
				info.write("         <cbc:Percent>"+ InputScreen.sPercent4 +"</cbc:Percent>");
				info.newLine();
				info.write("         <cac:TaxScheme>");
				info.newLine();
				info.write("            <cbc:ID>GST</cbc:ID>");
				info.newLine();
		        info.write("         </cac:TaxScheme>");
				info.newLine();
		        info.write("      </cac:TaxCategory>");
				info.newLine();
		        info.write("   </cac:AllowanceCharge>");
				info.newLine();
			}  // END Invoice Level Allowance
			
			// Invoice Level Charge	(print if not equal to 0.00)
			if (sChargeTotalAmount.equals("0.00")) {
				// do nothing
			} else {
				// print this xml section
				info.write("   <cac:AllowanceCharge>");
				info.newLine();
				info.write("      <cbc:ChargeIndicator>true</cbc:ChargeIndicator>");
				info.newLine();
				info.write("      <cbc:AllowanceChargeReason>" + allowanceChargeDescription + "</cbc:AllowanceChargeReason>");
				info.newLine();
				info.write("      <cbc:Amount currencyID=\"" + sCurrencyCode + "\">" + sChargeTotalAmount + "</cbc:Amount>");
				info.newLine();
				info.write("      <cac:TaxCategory>");
				info.newLine();
				info.write("         <cbc:ID>"+ InputScreen.sTaxCategoryID +"</cbc:ID>");
				info.newLine();
				info.write("         <cbc:Percent>"+ InputScreen.sPercent4 +"</cbc:Percent>");
				info.newLine();
				info.write("         <cac:TaxScheme>");
				info.newLine();
				info.write("            <cbc:ID>GST</cbc:ID>");
				info.newLine();
				info.write("         </cac:TaxScheme>");
				info.newLine();
				info.write("      </cac:TaxCategory>");
				info.newLine();
				info.write("   </cac:AllowanceCharge>");
				info.newLine();
			}  // END Invoice Level Charge
			

			// START - TAX Total
			info.write("   <cac:TaxTotal>");
			info.newLine();
			info.write("      <cbc:TaxAmount currencyID=\"" + sCurrencyCode + "\">" + taxAmount + "</cbc:TaxAmount>");
			info.newLine();
			info.write("      <cac:TaxSubtotal>");
			info.newLine();
			info.write("         <cbc:TaxableAmount currencyID=\"" + sCurrencyCode + "\">" + taxableAmount + "</cbc:TaxableAmount>");
			info.newLine();
			info.write("         <cbc:TaxAmount currencyID=\"" + sCurrencyCode + "\">" + taxAmount + "</cbc:TaxAmount>");
			info.newLine();
			info.write("         <cac:TaxCategory>");
			info.newLine();
			info.write("            <cbc:ID>"+ InputScreen.sTaxCategoryID +"</cbc:ID>");
			info.newLine();
			info.write("            <cbc:Percent>"+ InputScreen.sPercent4 +"</cbc:Percent>");
			info.newLine();
			info.write("            <cac:TaxScheme>");
			info.newLine();
			info.write("               <cbc:ID>GST</cbc:ID>");
			info.newLine();
	        info.write("            </cac:TaxScheme>");
			info.newLine();
		    info.write("         </cac:TaxCategory>");
			info.newLine();
		    info.write("      </cac:TaxSubtotal>");
			info.newLine();
		    info.write("   </cac:TaxTotal>");
			info.newLine();
			// END - TAX Total
			
			// START - Legal Monetary Total
			info.write("   <cac:LegalMonetaryTotal>");
			info.newLine();
			info.write("      <cbc:LineExtensionAmount currencyID=\"" + sCurrencyCode + "\">" + lineExtensionAmountTotal + "</cbc:LineExtensionAmount>");
			info.newLine();
			info.write("      <cbc:TaxExclusiveAmount currencyID=\"" + sCurrencyCode + "\">" + taxExclusiveAmount + "</cbc:TaxExclusiveAmount>");
			info.newLine();
			info.write("      <cbc:TaxInclusiveAmount currencyID=\"" + sCurrencyCode + "\">" + taxInclusiveAmount + "</cbc:TaxInclusiveAmount>");
			info.newLine();
			info.write("      <cbc:AllowanceTotalAmount currencyID=\"" + sCurrencyCode + "\">" + sAllowanceTotalAmount + "</cbc:AllowanceTotalAmount>");
			info.newLine();
			info.write("      <cbc:ChargeTotalAmount currencyID=\"" + sCurrencyCode + "\">" + sChargeTotalAmount + "</cbc:ChargeTotalAmount>");
			info.newLine();
            // pre-paid amount is hard coded to zero - future enhancement
			info.write("      <cbc:PrepaidAmount currencyID=\"" + sCurrencyCode + "\">" + "0.00" + "</cbc:PrepaidAmount>");
			info.newLine();
			info.write("      <cbc:PayableAmount currencyID=\"" + sCurrencyCode + "\">" + payableAmount + "</cbc:PayableAmount>");
			info.newLine();
	        info.write("   </cac:LegalMonetaryTotal>");
			info.newLine();						
	        // END - Legal Monetary Total
	        
	        // START - INVOICE LINES
			// Print while currentLineExtensionAmount > 0
			int currentLine = 1;
			double currentLineAmount = 0.00;
			String currentLineExtensionAmount = lineExtensionAmount1;
			String currentQuantity = quantity1;	
			String currentGoodsDescription = goodsDescription1;
			String currentPriceAmount = priceAmount1;	
			String currentDiscount = discount1;
			String currentBaseAmount = baseAmount1;					
			String sCurrentLineAllowanceCharge = sLineCharge1;
			
			try {
				currentLineAmount = Double.parseDouble(lineExtensionAmount1);
            } catch (NumberFormatException e) {
            	JOptionPane.showMessageDialog(null, "Warning - LineExtensionAmount1 is not a valid number" );
            }
						
			while(currentLine<4) {
			    // print the invoice line
				info.write("   <cac:InvoiceLine>");
				info.newLine();
				info.write("      <cbc:ID>" + currentLine +"</cbc:ID>");
				info.newLine();
				info.write("      <cbc:InvoicedQuantity unitCode=\"" + InputScreen.sUnitCode + "\">" + currentQuantity + "</cbc:InvoicedQuantity>");
				info.newLine();
				info.write("      <cbc:LineExtensionAmount currencyID=\"" + sCurrencyCode + "\">" + currentLineExtensionAmount + "</cbc:LineExtensionAmount>");
				info.newLine();
				// Start invoice line level allowance/charge
				// this is not needed if amount = 0.00
				if (sCurrentLineAllowanceCharge.length() > 0) {
			    	info.write("      <cac:AllowanceCharge>");
				    info.newLine();
				    info.write("         <cbc:ChargeIndicator>true</cbc:ChargeIndicator>");
				    info.newLine();
				    info.write("         <cbc:AllowanceChargeReason>Surcharge</cbc:AllowanceChargeReason>");
				    info.newLine();
				    info.write("         <cbc:Amount currencyID=\"" + sCurrencyCode + "\">" + sCurrentLineAllowanceCharge + "</cbc:Amount>");
				    info.newLine();
				    info.write("      </cac:AllowanceCharge>");
				    info.newLine();
				}
				// End invoice line level allowance/charge
				// start Item
				info.write("      <cac:Item>");
				info.newLine();
				info.write("         <cbc:Name>" + currentGoodsDescription + "</cbc:Name>");
				info.newLine();								
				// Classified Tax Category - similar to invoice level tax category
				info.write("         <cac:ClassifiedTaxCategory>");
				info.newLine();
				info.write("            <cbc:ID>"+ InputScreen.sTaxCategoryID +"</cbc:ID>");
				info.newLine();
				info.write("            <cbc:Percent>"+ InputScreen.sPercent4 +"</cbc:Percent>");
				info.newLine();
				info.write("            <cac:TaxScheme>");
				info.newLine();
				info.write("               <cbc:ID>GST</cbc:ID>");
				info.newLine();
		        info.write("            </cac:TaxScheme>");
				info.newLine();
		        info.write("         </cac:ClassifiedTaxCategory>");
				info.newLine();
				// end Classified Tax Category	
				// end Item
				info.write("      </cac:Item>");
				info.newLine();
				// Price
				info.write("      <cac:Price>");
				info.newLine();
				info.write("      <cbc:PriceAmount currencyID=\"" + sCurrencyCode + "\">" + currentPriceAmount + "</cbc:PriceAmount>");
				info.newLine();
				info.write("         <cac:AllowanceCharge>");
				info.newLine();
				// enhancement - currently hard coded to false
				info.write("         <cbc:ChargeIndicator>false</cbc:ChargeIndicator>");
				info.newLine();
				info.write("      <cbc:Amount currencyID=\"" + sCurrencyCode + "\">" + currentDiscount + "</cbc:Amount>");
				info.newLine();			
				info.write("      <cbc:BaseAmount currencyID=\"" + sCurrencyCode + "\">" + currentBaseAmount + "</cbc:BaseAmount>");
				info.newLine();
				info.write("         </cac:AllowanceCharge>");
				info.newLine();
				info.write("      </cac:Price>");
				info.newLine();
				// End Price
				info.write("   </cac:InvoiceLine>");
				info.newLine();
				
				// End of Line 1
				
				// Go to the next invoice line if one is needed
				// line2
				currentLine++;
				if (currentLine==2) {				
					try {
						currentLineAmount = Double.parseDouble(lineExtensionAmount2);
						currentQuantity = quantity2;
						currentGoodsDescription = goodsDescription2;
						currentLineExtensionAmount = lineExtensionAmount2;
						currentPriceAmount = priceAmount2;
						currentDiscount = discount2;
						currentBaseAmount = baseAmount2;				
						sCurrentLineAllowanceCharge = sLineCharge2;											
						if (currentLineAmount < 0.01) {
							currentLine = 4; // breaks out if nothing else to add
						}
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - LineExtensionAmount2 is not a valid number" );
	                }
					
				}
				// Line 3
				if (currentLine==3) {				
					try {
						currentLineAmount = Double.parseDouble(lineExtensionAmount3);
						currentQuantity = quantity3;
						currentGoodsDescription = goodsDescription3;
						currentLineExtensionAmount = lineExtensionAmount3;
						currentPriceAmount = priceAmount3;
						currentDiscount = discount3;
						currentBaseAmount = baseAmount3;				
						sCurrentLineAllowanceCharge = sLineCharge3;	
						if (currentLineAmount < 0.01) {
							currentLine = 4; // breaks out if nothing else to add
						}
	                } catch (NumberFormatException e) {
	                	JOptionPane.showMessageDialog(null, "Warning - LineExtensionAmount3 is not a valid number" );
	                }
					
				}  
	         }
				
			// END - Invoice Lines
			// END - INVOICE
			info.write("</Invoice>");
			// only needed if SDBH has been created
			if ((InputScreen.sMODE.equals("sFULLN2S")) || (InputScreen.sMODE.equals("sFULLS2N"))){
				info.newLine();
				info.write("</StandardBusinessDocument>");  		   	
    		}			
	        // END SDHB

 		
    		info.close();
    		// Now copy the output.txt file to a .XML file    		 		
    		File sourceFile = new File("C:/e-Invoice/Corner1-XML-Generator/Output/Output.txt");	    		
    		File destFile = new File("C:/e-Invoice/Corner1-XML-Generator/Output/"  + newfileName + ".xml");
    		 
    		if (sourceFile.renameTo(destFile)) {
    		    System.out.println("File renamed successfully");
    		} else {
    		    System.out.println("Failed to rename file");
    		}
    		
   		
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	    
	}
	
	
	

}
