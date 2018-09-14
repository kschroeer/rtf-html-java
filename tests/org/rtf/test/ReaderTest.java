package org.rtf.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;
import org.rtf.RtfHtml;
import org.rtf.RtfParseException;
import org.rtf.RtfReader;

public class ReaderTest {
	@Test
	public void testHtmlPage() throws RtfParseException {
		StringBuilder expectedBuilder = new StringBuilder();
		expectedBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
		expectedBuilder.append("<html>\n");
		expectedBuilder.append("  <head>\n");
		expectedBuilder.append("    <meta content=\"text/html;charset=UTF-8\" http-equiv=\"content-type\"/>\n");
		expectedBuilder.append("  </head>\n");
		expectedBuilder.append("  <body>\n");
		expectedBuilder.append("<p><span style=\"font-size:15px;\">Hello World</span></p><p>\n");
		expectedBuilder.append("  </body>\n");
		expectedBuilder.append("</html>\n");
		String expectedString = expectedBuilder.toString();

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
		String htmlString = formatter.format(reader.root, true);

		Assert.assertEquals(expectedString, htmlString);
	}

	@Test
	public void testFormatDump() throws IOException, RtfParseException {
		StringBuilder dumpBuilder = new StringBuilder();
		dumpBuilder.append("<div>\r\n");
		dumpBuilder.append("{\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD rtf (1)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD ansi (1)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD ansicpg (1252)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD deff (0)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD nouicompat (1)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD deflang (1031)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD viewkind (4)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD uc (1)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD pard (1)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD sa (200)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD sl (276)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD slmult (1)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD f (0)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD fs (22)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD lang (7)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:red'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("TEXT Hello World\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div style='color:green'>\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("&nbsp;\r\n");
		dumpBuilder.append("WORD par (1)\r\n");
		dumpBuilder.append("</div>\r\n");
		dumpBuilder.append("<div>\r\n");
		dumpBuilder.append("}\r\n");
		dumpBuilder.append("</div>\r\n");
		String expectedString = dumpBuilder.toString();

		StringBuilder rtfBuilder = new StringBuilder();
		rtfBuilder.append(
				"{\\rtf1\\ansi\\ansicpg1252\\deff0\\nouicompat\\deflang1031{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\r\n");
		rtfBuilder.append("{\\*\\generator Riched20 6.3.9600}\\viewkind4\\uc1 \r\n");
		rtfBuilder.append("\\pard\\sa200\\sl276\\slmult1\\f0\\fs22\\lang7 Hello World\\par\r\n");
		rtfBuilder.append("}\r\n");
		String rtfString = rtfBuilder.toString();

		RtfReader reader = new RtfReader();
		reader.parse(rtfString);

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			System.setOut(new PrintStream(baos));
			reader.root.dump();
			Assert.assertEquals(expectedString, baos.toString());
		}
	}

	@Test
	public void testParseError() {
		String rtfString = "This text is not a valid RTF string.";
		Throwable t = null;

		try {
			RtfReader reader = new RtfReader();
			reader.parse(rtfString);
		} catch (Exception e) {
			t = e;
		}

		Assert.assertNotNull(t);
		Assert.assertTrue(t instanceof RtfParseException);
	}
}