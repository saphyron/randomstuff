package group01_0mperson2;

public class Person {
	private String name;
	// association: --> 0..1 Group
	private Group group; // nullable

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	// -------------------------------------------------------------------------

	/** Note: nullable return value. */
	public Group getGroup() {
		return group;
	}

	/**
	 * Sets the group as this person's group
	 */
	public void setGroup(Group group) {
		if (this.group != group) {
			Group oldGroup = this.group;
			if (oldGroup != null) {
				oldGroup.removePerson(this);
			}
			this.group = group;
			if (group != null) {
				group.addPerson(this);
			}
		}
	}

	
}
