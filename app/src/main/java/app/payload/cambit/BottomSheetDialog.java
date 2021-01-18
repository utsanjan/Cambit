package app.payload.cambit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment {

	int bpm_internal = 0;

	BottomSheetDialog passData(int bpm_) {
		bpm_internal = bpm_;
		return this;
	}

	@SuppressLint("SetTextI18n")
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.bottom_sheet,
				container, false);

		TextView bpm = v.findViewById(R.id.bpm);

		if (bpm_internal <= 60 || bpm_internal >= 100) {
			if (bpm_internal > 120) {
				bpm.setTextColor(ContextCompat.getColor(getContext(), android.R.color.holo_red_light));
			} else {
				bpm.setTextColor(ContextCompat.getColor(getContext(), android.R.color.holo_green_light));
			}
		} else {
			bpm.setTextColor(ContextCompat.getColor(getContext(), android.R.color.holo_red_dark));
		}
		bpm.setText(bpm_internal + " bpm");
		return v;
	}
}
