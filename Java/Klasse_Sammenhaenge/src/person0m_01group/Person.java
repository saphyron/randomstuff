package person0m_01group;

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

	/** Note: Nullable return value. */
	public Group getGroup() {
		return group;
	}

	/**
	 * Sets the group as this person's group. Note: Nullable param group.
	 */
	public void setGroup(Group group) {
		if (this.group != group) {
			this.group = group;
		}
	}
}
