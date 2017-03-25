package uk.tanton.legislation.fetcher;

import uk.tanton.legislation.fetcher.domain.legislation.Part;
import uk.tanton.legislation.fetcher.domain.legislation.Pblock;
import uk.tanton.legislation.fetcher.domain.legislation.group.P1;
import uk.tanton.legislation.fetcher.domain.legislation.group.P1Group;
import uk.tanton.legislation.fetcher.domain.legislation.group.P2;
import uk.tanton.legislation.fetcher.domain.legislation.group.Text;

import java.util.List;

public class LegislationUtils {


    public static String convertPartsToString(final List<Part> parts) {
        final StringBuilder sb = new StringBuilder();

        for (final Part p : parts) {
            sb.append("\n==========\n");
            if (stringIsPresent(p.getTitle())) {
                sb.append(p.getTitle());
            }

            if (stringIsPresent(p.getNumber())) {
                sb.append(" (").append(p.getNumber()).append(")");
            }

            addAllP1GroupsToString(p.getP1Group(), sb);

            for (Pblock pblock : p.getPblock()) {
                sb.append("\n\n").append(pblock.getTitle());
                addAllP1GroupsToString(pblock.getP1Group(), sb);
            }
        }

        return sb.toString();
    }

    private static void addAllP1GroupsToString(final List<P1Group> p1Groups, final StringBuilder sb) {
        for (final P1Group p1Group : p1Groups) {
            sb.append("\n").append(p1Group.getTitle());
            for (P1 p1 : p1Group.getP1()) {
//                p1.getP1Para().getP2().ifPresent(p2s -> p2s.forEach(p2 -> sb.append("\n").append(p2.getP2para().getContent())));

                p1.getP1Para().getP2().ifPresent(p2s -> {
                    for (P2 p2 : p2s) {
                        sb.append("\n");
                        final Text text = p2.getP2para().getText();
                        if (text != null)
                            text.getContent().ifPresent(sb::append);
                    }
                });

                p1.getP1Para().getText().ifPresent(t -> sb.append("\n").append(t.getContent()));
            }
        }
    }

    public static boolean stringIsPresent(final String s) {
        if (s != null && s.length() > 0) {
            return true;
        }
        return false;
    }
}
