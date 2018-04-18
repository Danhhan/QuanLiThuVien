package MyFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.develop.QuanLiThuVien.R;

import java.util.Calendar;

/**
 * Created by Develop on 4/14/2018.
 */

public class DatePickerFragmentNgayTra extends android.support.v4.app.DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar=Calendar.getInstance();
        int iNam=calendar.get(calendar.YEAR);
        int iThang=calendar.get(calendar.MONTH);
        int iNgay=calendar.get(calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this,iNgay,iThang,iNam);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {


        EditText editNgaytra=getActivity().findViewById(R.id.edtNgayTra);
        month=month+1;
        String ngay = "";
        String thang = "";
        if(date<10){
            ngay="0" + date;
        }else {
            ngay=""+date;
        }
        if(month<10){
            thang ="0" + month;
        }else {
            thang="" + month;
        }

        String ngaytra=ngay +"/" + thang +  "/" + year;

        editNgaytra.setText(ngaytra);
    }
}
