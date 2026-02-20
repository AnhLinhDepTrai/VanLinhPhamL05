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
            {"Android", "ART", "AVD", "Intent", "AOT",
                    "Emulator", "Activity", "Fragment", "Life Cycle events"};

    String[] definition = new String[]
            {"Open source software stack",
                    "Android Runtime Environment",
                    "Android Virtual Device",
                    "An abstract description of an operation to be performed",
                    "Ahead of Time compilation",
                    "Simulates Android devices on your computer",
                    "Application component that provides a screen",
                    "A mini activity",
                    "These methods are called when ....."};


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
                    + " must implement OnItemSelectedListener");
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
