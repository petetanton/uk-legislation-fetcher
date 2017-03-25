package uk.tanton.legislation.fetcher.javax;

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import org.w3c.dom.Node;
import uk.tanton.legislation.fetcher.domain.legislation.group.Text;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TextAdapter extends XmlAdapter<Object, Text> {

    @Override
    public Text unmarshal(Object v) throws Exception {
            final StringBuilder sb = new StringBuilder();
        if (v instanceof ElementNSImpl) {
            ElementNSImpl object = (ElementNSImpl) v;
            recursiveAppendStringFromChildren(object.getFirstChild(), sb);

            final String text = sb.toString();
//            System.out.println(text);

        }
        return new Text(sb.toString());
    }

    @Override
    public Object marshal(Text v) throws Exception {
        throw new Exception("Marshall has not been implemented in TextAdapter.class");
    }

    private void recursiveAppendStringFromChildren(final Node node, final StringBuilder sb) {
        if (node.getNodeValue() != null)
            sb.append(node.getNodeValue());

        if (node.getFirstChild() != null) {
            recursiveAppendStringFromChildren(node.getFirstChild(), sb);
        }

        if (node.getNextSibling() != null) {
            recursiveAppendStringFromChildren(node.getNextSibling(), sb);
        }
    }

}
