//Gursewak Singh
//V00875106
//Assignment 1

public class Contact
{
	private String name;
	private PhoneNumberList	number;

	// Purpose:
	//	initialize this instance of Contact
	// 	with no PhoneNumber
	//
	public Contact (String theName)
	{
		name = theName;
		number = new PhoneNumberList() ;
	}

	// Purpose:
	//	initialize this instance of Contact
	//	add p to the list of phone numbers associated with
	//	this Contact
	//
	public Contact (String theName, PhoneNumber p)
	{
		name = theName;
		number = new PhoneNumberList();
		number.add(p);
		// You must allocate a PhoneNumberList here
	}

	// Purpose:
	//	return the name associated with this instance
	//
	public String getName ()
	{
		return name;
	}

	// Purpose:
	//	change the name associated with this instance to be newName
	//
	public void setName(String newName)
	{
		name = newName;
	}

	// Purpose:
	//	add a new phone number to this contact
	//	there is no maximum number of phone numbers that can be
	//	assigned to a contact.
	//
	public void addNumber (PhoneNumber p)
	{
		number.add(p);
	}

	// Purpose:
	//	remove p from the list of PhoneNumbers associated with this contact
	//	if p is not in the list, do nothing.
	//
	public void removeNumber (PhoneNumber p)
	{
		number.remove(number.find(p));
	}

	// Purpose:
	//	return the count of PhoneNumbers associated with this contact
	//
	public int getNumberCount()
	{
		return number.size();
	}

	// Purpose:
	//	return the phone at index pos from this contact
	//
	// Pre-condition:
	//	pos >= 0 AND
	//	pos < this.getNumberCount()
	//
	public PhoneNumber getNumber (int pos)
	{
		PhoneNumber x = new PhoneNumber("INVALID NUMBER", "INVALID NAME");
		if(pos >= 0 && pos < this.getNumberCount())
			return number.get(pos);
		else
			return x;

		// NOTE NOTE NOTE
		//
		// This line needs to be removed.  It is only
		// so the tester works.  You should NOT
		// allocate a new PhoneNumber in this method

	}

	// Purpose:
	//	return a String representation of this contact
	//
	public String toString()
	{
		String a = name;

		for (int i=0;i<number.size();i++)
		{
			a += "\n";
			a += number.get(i);
		}
		return a;
	}
}
