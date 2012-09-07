package ch.deathmar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class CountYusukeTest {

    @DataPoints
    public static Fixture[] yusuke() {
        String[] yusuke = { "yusuke", "Yusuke", "ゆうすけ", "ゆーすけ", "ユウスケ", " 雄助",
                "裕介yusukey", "裕典", "優介", "遊助" };
        return fixtures(yusuke, true);
    }

    @DataPoints
    public static Fixture[] notYusuke() {
        String[] notYusuke = { "yu-suke", "yosuke", "yamamoto" };
        return fixtures(notYusuke, false);
    }

    @Theory
    public void testIsYusuke(Fixture param) throws Exception {
        assertThat(CountYusuke.isYusuke(param.name), is(param.isYusuke));
    }

    private static Fixture[] fixtures(String[] y, boolean isYusuke) {
        ArrayList<Fixture> list = new ArrayList<Fixture>();
        for (String name : y) {
            list.add(new Fixture(name, isYusuke));
        }
        return list.toArray(new Fixture[list.size()]);
    }

    static class Fixture {
        final String name;
        final boolean isYusuke;

        public Fixture(String name, boolean isYusuke) {
            this.name = name;
            this.isYusuke = isYusuke;
        }
    }
}