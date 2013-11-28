package game.logic.swipl;

import game.logic.Movement;
import game.model.Pawn;
import game.util.Utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import jpl.Atom;
import jpl.Integer;
import jpl.Query;
import jpl.Term;
import jpl.Variable;

public class HoundActionChooser {
    // Query q1 = new Query("consult", new Term[] { new
    // Atom("resources/all.pro") });
    // System.out.println("consult " + (q1.query() ? "succeeded" :
    // "failed"));
    //
    //    // @formatter:off
    //    Query q2 = new Query("one_move", new Term[] { 
    //                new jpl.Integer(1), new jpl.Integer(1), new jpl.Integer(1), new jpl.Integer(3), 
    //                new jpl.Integer(1), new jpl.Integer(5), new jpl.Integer(1), new jpl.Integer(7), 
    //                new jpl.Integer(2), new jpl.Integer(6),
    //                new Variable("Wx"), new Variable("Wy"), new Variable("Rx"), new Variable("Ry") });
    //    // @formatter:on
    //
    // if (!q2.isOpen()) {
    // q2.open();
    // }
    // Hashtable<Variable, String> solution = (Hashtable<Variable, String>)
    // q2.nextElement();
    // q2.close();

    private Variable rxVar = new Variable("Rx");
    private Variable ryVar = new Variable("Ry");
    private Variable mxVar = new Variable("Mx");
    private Variable myVar = new Variable("My");

    public HoundActionChooser() {
        Query consultQuery = new Query("consult", new Term[] { new Atom("resources/all.pro") });
        if (!consultQuery.query()) {
            throw new RuntimeException(getClass().getName() + ": consult query failed.");
        }
    }

    public Movement getHoundAction(List<Pawn> hounds, Pawn fox) {

        Collections.sort(hounds, new Comparator<Pawn>() {
            @Override
            public int compare(Pawn pawn1, Pawn pawn2) {
                if (pawn1.getY() - pawn2.getY() != 0) {
                    return pawn1.getX() - pawn2.getX();
                } else {
                    return pawn1.getY() - pawn2.getY();
                }
            }
        });

        Iterator<Pawn> houndsIterator = hounds.iterator();
        Pawn hound = houndsIterator.next();

        jpl.Integer h0X = new Integer(hound.getX());
        jpl.Integer h0Y = new Integer(hound.getY());
        hound = houndsIterator.next();
        jpl.Integer h1X = new Integer(hound.getX());
        jpl.Integer h1Y = new Integer(hound.getY());
        hound = houndsIterator.next();
        jpl.Integer h2X = new Integer(hound.getX());
        jpl.Integer h2Y = new Integer(hound.getY());
        hound = houndsIterator.next();
        jpl.Integer h3X = new Integer(hound.getX());
        jpl.Integer h3Y = new Integer(hound.getY());

        jpl.Integer fX = new Integer(fox.getX());
        jpl.Integer fY = new Integer(fox.getY());

        // @formatter:off
        Query query = new Query("move", new Term[] { 
              h0X, h0Y, h1X, h1Y, h2X, h2Y, h3X, h3Y, fX, fY, mxVar, myVar, rxVar, ryVar });
        // @formatter:on

        query.open();
        Hashtable<String, Integer> solution = (Hashtable<String, Integer>) query.getSolution();
        query.close();

        if (solution == null) {
            System.err.println("Answer not found for query: " + query);
        }

        Pawn pawn = Utils.getPawn((solution.get(mxVar.name)).intValue(), solution.get(myVar.name).intValue(), hounds);

        return new Movement(pawn, solution.get(rxVar.name).intValue(), solution.get(ryVar.name).intValue());
    }
}
