package org.rtf.test;

import org.junit.Assert;
import org.junit.Test;
import org.rtf.RtfHtml;
import org.rtf.RtfParseException;
import org.rtf.RtfReader;

public class FontTest {
	@Test
	public void testFontNormal() throws RtfParseException {
		String expectedString = "<p><span style=\"font-size:15px;\">Hello World</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\f0\\fs22\\lang7 Hello World\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testDifferentFontSizes() throws RtfParseException {
		String expectedString = "<p><span style=\"font-size:16px;\">Hello</span><span style=\"font-size:19px;\"> </span><span style=\"font-size:22px;\">World</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\f0\\fs24\\lang7 Hello\\fs28  \\fs32 World\\fs22\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testFontColor() throws RtfParseException {
		String expectedString = "<p><span style=\"font-size:15px;color:#8fb08c;\">Hello World</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\colortbl ;\\red143\\green176\\blue140;}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\cf1\\f0\\fs22\\lang7 Hello World\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testBold() throws RtfParseException {
		String expectedString = "<p><span style=\"font-weight:bold;font-size:15px;\">Hello World</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\b\\f0\\fs22\\lang7 Hello World\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testItalic() throws RtfParseException {
		String expectedString = "<p><span style=\"font-style:italic;font-size:15px;\">Hello World</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\i\\f0\\fs22\\lang7 Hello World\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testUnderline() throws RtfParseException {
		String expectedString = "<p><span style=\"text-decoration:underline;font-size:15px;\">Hello World</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\ul\\f0\\fs22\\lang7 Hello World\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testStrikethrough() throws RtfParseException {
		String expectedString = "<p><span style=\"text-decoration:strikethrough;font-size:15px;\">Hello World</span></p><p>";

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\strike\\f0\\fs22\\lang7 Hello World\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		RtfHtml formatter = new RtfHtml();
		String htmlString = formatter.format(reader.root);

		Assert.assertEquals(expectedString, htmlString);
	}
}