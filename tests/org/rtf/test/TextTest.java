package org.rtf.test;

import org.junit.Assert;
import org.junit.Test;
import org.rtf.RtfHtml;
import org.rtf.RtfParseException;
import org.rtf.RtfReader;

public class TextTest {
	@Test
	public void testParagraphs() throws RtfParseException {
		String expectedString = "<p><span style=\"font-family:'Calibri';font-size:16px;\">This is the first line.</span></p><p><span style=\"font-family:'Calibri';font-size:19px;\">And this is the second one.</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\f0\\fs24\\lang7 This is the first line.\\par\r\n");
		rtfBuilder.append("\\fs28 And this is the second one.\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testParagraphsWithUnchangedFontFormat() throws RtfParseException {
		String expectedString = "<p><span style=\"font-family:'Calibri';font-size:15px;\">This is the first line.</span></p>"
				+ "<p><span style=\"font-family:'Calibri';font-size:15px;\">And this is the second one with unchanged font format.</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031\r\n");
		rtfBuilder.append("{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\f0\\fs22\\lang7 This is the first line.");
		rtfBuilder.append("\\par And this is the second one with unchanged font format.");
		rtfBuilder.append("\\par}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testEscapeSequences() throws RtfParseException {
		String expectedString = "<p><span style=\"font-family:'Calibri';font-size:15px;\">Hello {World}</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\f0\\fs22\\lang7 Hello \\{World\\}\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testUnicodeCharacters() throws RtfParseException {
		String expectedString = "<p><span style=\"font-family:'Calibri';font-size:15px;\">Kay Schr&#246;er</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\f0\\fs22\\lang7 Kay Schr\\'f6er\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testEntities() throws RtfParseException {
		String expectedString = "<p><span style=\"font-family:'Calibri';font-size:15px;\">Hello </span><span style=\"font-family:'Tahoma';font-size:15px;\">&ndash; &nbsp; World</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append("{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031");
		rtfBuilder.append("{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}{\\f1\\fnil Tahoma;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\f0\\fs22\\lang7 Hello ");
		rtfBuilder.append("\\f1\\endash  \\~ World\\f0\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}
}