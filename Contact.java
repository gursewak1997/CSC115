public class Contact
{
	private String name;
	private PhoneNumberList	numbers;

	// Purpose:
	//	initialize this instance of Contact
	// 	with no PhoneNumber
	//
	public Contact (String theName)
	{
		// You must allocate a PhoneNumberList here
	}

	// Purpose:
	//	initialize this instance of Contact
	//	add p to the list of phone numbers associated with
	//	this Contact
	//
	public Contact (String theName, PhoneNumber p)
	{
		// You must allocate a PhoneNumberList here
	}

	// Purpose:
	//	return the name associated with this instance
	//
	public String getName ()
	{
		return "not done";
	}

	// Purpose:
	//	change the name associated with this instance to be newName
	//
	public void setName(String newName)
	{
	}

	// Purpose:
	//	add a new phone number to this contact
	//	there is no maximum number of phone numbers that can be
	//	assigned to a contact.
	//
	public void addNumber (PhoneNumber p)
	{
	}

	// Purpose:
	//	remove p from the list of PhoneNumbers associated with this contact
	//	if p is not in the list, do nothing.
	//
	public void removeNumber (PhoneNumber p)
	{
	}

	// Purpose:
	//	return the count of PhoneNumbers associated with this contact
	//
	public int getNumberCount()
	{
		return -1;
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
		// NOTE NOTE NOTE
		//
		// This line needs to be removed.  It is only
		// so the tester works.  You should NOT
		// allocate a new PhoneNumber in this method
		return new PhoneNumber("WARNING", "fix this");
	}

	// Purpose:
	//	return a String representation of this contact
	//
	public String toString()
	{
		String s = name;

		for (int i=0;i<numbers.size();i++)
		{
			s += "\n";
			s += numbers.get(i);
		}
		return s;
	}
}
