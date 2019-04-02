package sunrise.smartparking.iqpay.admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import sunrise.smartparking.iqpay.objects.ProblemReport;
import sunrise.smartparking.iqpay.R;

public class SupportActivityFragment extends Fragment
{
    private class Components { EditText editTextProblemType, editTextSubject, editTextProblemDetails; Spinner spinnerProblemPriority; Button buttonSend;}
    Components components;
    View view;

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_support_activity, container, false);
        bindUI();
            return view;
        }

        private void bindUI()
        {
            components = new Components();
            components.buttonSend = (Button) view.findViewById(R.id.buttonReceiptExitCar);
            components.editTextProblemType = (EditText) view.findViewById(R.id.editTextProblemType);
            components.editTextSubject = (EditText) view.findViewById(R.id.editTextProblemSubject);
            components.editTextProblemDetails = (EditText) view.findViewById(R.id.editTextProblemDetails);
            components.spinnerProblemPriority = (Spinner) view.findViewById(R.id.comboBoxProblemPriority);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.problem_priority_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            components.spinnerProblemPriority.setAdapter(adapter);

            components.buttonSend.setOnClickListener(sendEmail());
        }
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    private View.OnClickListener sendEmail()
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),"Submitting the request...", Toast.LENGTH_LONG).show();
                ProblemReport problemReport = new ProblemReport(components.editTextProblemType.getText().toString(), components.editTextSubject.getText().toString(), components.spinnerProblemPriority.getSelectedItem().toString(), components.editTextProblemDetails.getText().toString());
                Gson gson = new Gson();
                String stringProblemReportEmail= gson.toJson(problemReport);

                OkHttpClient client = new OkHttpClient();
                RequestBody body = RequestBody.create(JSON, stringProblemReportEmail);

                // todo: add URL here
                Request request = new Request.Builder()
                        .url("http://95.159.105.242:3000/api/") // todo: replace URL with iqPay API
                        .post(body)
                        .build();
                Response response = null;
                try
                {
                    response = client.newCall(request).execute();
                    if(response.isSuccessful())
                    {
                        Toast.makeText(getActivity(),"Problem report was submitted successfully.", Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        };
    }

}
