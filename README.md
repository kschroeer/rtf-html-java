# rtf-html-java
@author Kay Schröer (acsf.dev@gmail.com)

Background of the project: For some of my applications, I was looking for a way to convert RTF texts to HTML so that they could be displayed in an embedded web view.  
Googling around turned up several matches, the most common being the use of `javax.swing.text.EditorKit`:

```java
public String toHTML(File file) throws Exception {
    JEditorPane p = new JEditorPane();
    p.setContentType("text/rtf");

    EditorKit kitRtf = p.getEditorKitForContentType("text/rtf");
    kitRtf.read(new FileReader(file), p.getDocument(), 0);
    kitRtf = null;

    EditorKit kitHtml = p.getEditorKitForContentType("text/html");
    Writer writer = new StringWriter();
    kitHtml.write(writer, p.getDocument(), 0, p.getDocument().getLength());

    return writer.toString();
}
```

The problem with this solution is its close connection to the Swing toolkit, which I do not use in my applications. In addition, this snippet is difficult to port to other platforms (such as Android), which was also one of my requirements.

Another commonly recommended method is the use of command-line tools. However, this would involve building an infrastructure with a server and e.g. require a REST API. I really did not want to do this effort.

So what I had in mind was an API that manages a handful of classes and is written in pure Java. I found [rtf-html-php](https://github.com/henck/rtf-html-php). The project is written entirely in PHP, but perfectly meets all my requirements and was easy to port. I had to make some changes, such as set data types for all variables or replace the expandable arrays with the ArrayList, but my project is a very accurate adaptation of the PHP library.

## Features

- Parsing of files, streams and strings
- Including paragraphs
- Support of font styles like bold, italic, underline, strike through and hidden
- Handling of different font sizes, text colors and background colors
- Escaping special characters
- Building HTML entities from unicode characters

## Usage

```java
import java.io.File;

import org.rtf.RtfHtml;
import org.rtf.RtfParseException;
import org.rtf.RtfReader;

public class Demo {

    public static void main(String[] args) {
        File file = new File(args[0]);
        RtfReader reader = new RtfReader();
        RtfHtml formatter = new RtfHtml();

        try {
            reader.parse(file);
            System.out.println(formatter.format(reader.root, true));
        } catch (RtfParseException e) {
            e.printStackTrace();
        }
    }
}
```
