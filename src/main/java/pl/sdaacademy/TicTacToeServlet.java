package pl.sdaacademy;

import pl.sdaacademy.model.TicTacToe;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class TicTacToeServlet extends HttpServlet {

    private int win1 = 0;
    private int win2 = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession(true); // jezelie sesji nie ma to ja tworzy (true)


        TicTacToe ticTacToe = (TicTacToe) session.getAttribute("board");

        if (ticTacToe == null) {
            ticTacToe = new TicTacToe(Integer.parseInt(getServletConfig().getInitParameter("player")));
            session.setAttribute("board", ticTacToe);
        }

        if(req.getParameter("x") != null && req.getParameter("y") != null) {

            int x = Integer.parseInt(req.getParameter("x"));
            int y = Integer.parseInt(req.getParameter("y"));
            ticTacToe.setField(x, y);
        }

        PrintWriter out = resp.getWriter();
        out.println("<a href=\"put?a=0\">ZAGRAJ PONOWNIE <br /> </a>");
        out.print("<h1>Zaczyna zawodnik o znaczniku :  " + getServletConfig().getInitParameter("player") + "!</h1>");
        if (req.getParameter("a") != null){
            ticTacToe.zero();
        }

        out.println(renderBoard(ticTacToe));

        out.println("TABLICA WYNIKOW");
        out.print("<h2></h2>");
        out.println("ZAWODNIK 1 WYGRAL " + win1 + " RAZY <br />");
        out.println("ZAWODNIK 2 WYGRAL " + win2 + " RAZY <br />");
        out.println("");


        if (ticTacToe.isWinner(1) & !ticTacToe.isWinner(2)){
            out.print("WYGRAL PLAYER 1  !! ");
            win1++;
        }
        if (ticTacToe.isWinner(2) & !ticTacToe.isWinner(1)){
            out.print("WYGRAL PLAYER 2 !! ");
            win2++;
        }
        if (ticTacToe.isWinner(2) & ticTacToe.isWinner(1)){
            out.print("PRZEGRALES PRZESTAN KLIKAC  !! ");
        }


    }
    private String renderBoard(TicTacToe ticTacToe){
        return renderField(0,0,ticTacToe)+"|"+renderField(1,0,ticTacToe)+"|" + renderField(2,0,ticTacToe)+
                "<br />" +  "----<br / >"
                + renderField(0,1,ticTacToe)+"|"+renderField(1,1,ticTacToe)+"|" + renderField(2,1,ticTacToe)+
                "<br />" +  "----<br / >"
                +renderField(0,2,ticTacToe)+"|"+renderField(1,2,ticTacToe)+"|" + renderField(2,2,ticTacToe)+
                "<br />" +  "----<br / >";
    }

    private String renderField(int x, int y, TicTacToe ticTacToe) {
        if (ticTacToe.getField(x, y) == 0) {
            return "<a href=\"put?x=" + x + "&y=" + y + "\">&nbsp;</a>";
        }
        return ticTacToe.getField(x, y) == 1 ? "o":"x";
    }

}
