package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
		Map<String, List<Contact>> groups = new HashMap<>();

		public boolean addGroup(String nameGroup) {
				if (!groups.containsKey(nameGroup)) {
						this.groups.put(nameGroup, new ArrayList<>());
						return true;
				}
				return false;
		}

		public void addContactToGroup(Contact contact, String ... group) {
				for (String currentGroup : group) {
						if (groups.containsKey(currentGroup)) {
								List<Contact> contacts = groups.get(currentGroup);
								if (!contacts.contains(contact)) {
										contacts.add(contact);
								}
						}
				}
		}

		public List<Contact> findContactsByGroup(String group) {
				return groups.get(group);
		}

		public Contact findContactByNumber(String phoneNumber) {
				for (List<Contact> contacts : groups.values()) {
						for (Contact contact : contacts) {
								if (contact.getPhoneNumber().equals(phoneNumber)) {
										return contact;
								}
						}
				}
				return null;
		}

		@Override
		public String toString() {
				return "PhoneBook{" +
												"groups=" + groups +
												'}';
		}
}