package danil;

import java.util.HashMap;
import java.util.Map;


public class Uzel {

    private final int id_;
    private Map<Integer, Uzel> arr = new HashMap<>();

    public Uzel(int id)
    {
        id_ = id;
    }

    public final int getId()
    {
        return id_;
    }

    public void setToArr(Uzel a){
        arr.put(a.getId(), a);
    }

    public void delToArr(int id){
        arr.remove(id);
    }

    public Uzel getSosed(int id)
    {
        return arr.get(Integer.valueOf(id));
    }

    public boolean hasPathTo(int other)
    {
        Uzel otherUzel = getSosed(Integer.valueOf(other));
        if (otherUzel != null)
        {
            return true;
        }
        else
        {
            for (Integer key : arr.keySet())
            {
                Uzel sosed = arr.get(key);
                if (sosed.hasPathTo(other))
                {
                    return true;
                }
            }

            return false;
        }
    }

}
