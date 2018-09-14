package org.rtf;

/**
 * This class specifies a structure of layout information used for text
 * formatting in the span tag and obtained from RTF control words.
 *
 * @author <a href="mailto:acsf.dev@gmail.com">Kay Schröer</a>
 */
public class RtfState implements Cloneable {
	/**
	 * Attribute that specifies that text should be written in bold
	 */
	public boolean bold;

	/**
	 * Attribute that specifies that text should be written in italic
	 */
	public boolean italic;

	/**
	 * Attribute that specifies that text should be underlined
	 */
	public boolean underline;

	/**
	 * Attribute that specifies that text should be striked through
	 */
	public boolean strike;

	/**
	 * Attribute that specifies that text should be hidden
	 */
	public boolean hidden;

	/**
	 * Font size in pixels
	 */
	public int fontSize;

	/**
	 * Text color as a position in the color table
	 */
	public int textColor;

	/**
	 * Background color as a position in the color table
	 */
	public int background;

	/**
	 * Creates a new RTF state.
	 */
	public RtfState() {
		reset();
	}

	/**
	 * Clones the layout information.
	 *
	 * @return a copy of this object
	 */
	@Override
	public Object clone() {
		RtfState newState = new RtfState();
		newState.bold = this.bold;
		newState.italic = this.italic;
		newState.underline = this.underline;
		newState.strike = this.strike;
		newState.hidden = this.hidden;
		newState.fontSize = this.fontSize;
		newState.textColor = this.textColor;
		newState.background = this.background;
		return newState;
	}

	/**
	 * Compares two states for equality.
	 *
	 * @param obj
	 *            the object to compare with
	 * @return {@code true} if and only if the argument is not {@code null} and
	 *         is a {@code RtfState} object that contains the same layout
	 *         information as this object
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RtfState)) {
			return false;
		}

		RtfState anotherState = (RtfState) obj;
		return this.bold == anotherState.bold && this.italic == anotherState.italic
				&& this.underline == anotherState.underline && this.strike == anotherState.strike
				&& this.hidden == anotherState.hidden && this.fontSize == anotherState.fontSize
				&& this.textColor == anotherState.textColor && this.background == anotherState.background;
	}

	/**
	 * Sets the attributes to default values.
	 */
	public void reset() {
		bold = false;
		italic = false;
		underline = false;
		strike = false;
		hidden = false;
		fontSize = 0;
		textColor = 0;
		background = 0;
	}
}