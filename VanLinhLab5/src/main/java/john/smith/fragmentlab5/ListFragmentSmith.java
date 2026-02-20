/** Author's Name: Van Linh Pham
 * Student's ID: N01681546
 * */
package john.smith.fragmentlab5;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

public class ListFragmentSmith extends Fragment {

    private ListView listView;

    String[] concepts = new String[]
            {getString(R.string.and), getString(R.string.art), getString(R.string.avd), getString(R.string.inten), getString(R.string.aot),
                    getString(R.string.emu), getString(R.string.act), getString(R.string.frag), getString(R.string.cycle)};

    String[] definition = new String[]
            {getString(R.string.opensoruce),
                    getString(R.string.runenv),
                    getString(R.string.virtul),
                    getString(R.string.an_abstract_description_of_an_operation_to_be_performed),
                    getString(R.string.complition),
                    getString(R.string.simulattingkwergnrlign),
                    getString(R.string.component),
                    getString(R.string.mini),
                    getString(R.string.callmethod)};


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ListFragmentSmith() {

    }


    public static ListFragmentSmith newInstance(String param1, String param2) {
        ListFragmentSmith fragment = new ListFragmentSmith();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public interface OnItemSelectedListener {
        void onItemSelected(String definitionText);
    }

    private OnItemSelectedListener listener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + getString(R.string.exceptionOnattach));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = view.findViewById(R.id.VanLinhlistView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, concepts);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, v, position, id) -> {
            listView.setSelector(android.R.color.holo_blue_dark);

            if (listener != null) {
                listener.onItemSelected(definition[position]); // send the corresponding definition
            }
        });

        return view;
    }
}
