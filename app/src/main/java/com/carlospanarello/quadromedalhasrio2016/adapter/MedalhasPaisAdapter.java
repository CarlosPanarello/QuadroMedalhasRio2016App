package com.carlospanarello.quadromedalhasrio2016.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlospanarello.quadromedalhasrio2016.ModelHelper;
import com.carlospanarello.quadromedalhasrio2016.R;
import com.carlospanarello.quadromedalhasrio2016.model.ItemMedalhasPais;

import java.util.List;

/**
 * Created by carlospanarello on 10/08/16.
 */
public class MedalhasPaisAdapter extends ArrayAdapter<ItemMedalhasPais> {

    private List<ItemMedalhasPais> items;
    private int rowResourceID;
    ModelHelper db;
    ItemMedalhasPais medalha;
    Context context;

    public MedalhasPaisAdapter(Context context, int rowResourceId, List<ItemMedalhasPais> items) {
        super(context, rowResourceId, items);
        this.context = context;
        this.rowResourceID = rowResourceId;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        db = new ModelHelper(context);
        View v = vi.inflate(rowResourceID, null);

        medalha = items.get(position);

        if (medalha != null) {
            TextView txtNomeEsporte = (TextView) v.findViewById(R.id.descSport);
            TextView txtGold = (TextView) v.findViewById(R.id.goldCount);
            TextView txtSilver = (TextView) v.findViewById(R.id.silverCount);
            TextView txtBronze = (TextView) v.findViewById(R.id.bronzeCount);
            ImageView imgSport = (ImageView) v.findViewById(R.id.imgSport);

            txtNomeEsporte.setText(String.valueOf(medalha.getSport_name()));
            txtGold.setText(String.valueOf(medalha.getGold_count()));
            txtSilver.setText(String.valueOf(medalha.getSilver_count()));
            txtBronze.setText(String.valueOf(medalha.getBronze_count()));

            switch(medalha.getId_sport().toUpperCase()) {
                case "AR":
                    imgSport.setImageResource(R.drawable.rio_o_seal_ar_blue);
                    break;
                case "AT":
                    imgSport.setImageResource(R.drawable.rio_o_seal_at_blue);
                    break;
                case "BD":
                    imgSport.setImageResource(R.drawable.rio_o_seal_bd_blue);
                    break;
                case "BK":
                    imgSport.setImageResource(R.drawable.rio_o_seal_bk_blue);
                    break;
                case "BX":
                    imgSport.setImageResource(R.drawable.rio_o_seal_bx_blue);
                    break;
                case "CS":
                    imgSport.setImageResource(R.drawable.rio_o_seal_cs_blue);
                    break;
                case "CF":
                    imgSport.setImageResource(R.drawable.rio_o_seal_cf_blue);
                    break;
                case "CB":
                    imgSport.setImageResource(R.drawable.rio_o_seal_cb_blue);
                    break;
                case "CR":
                    imgSport.setImageResource(R.drawable.rio_o_seal_cr_blue);
                    break;
                case "CT":
                    imgSport.setImageResource(R.drawable.rio_o_seal_ct_blue);
                    break;
                case "CM":
                    imgSport.setImageResource(R.drawable.rio_o_seal_cm_blue);
                    break;
                case "FE":
                    imgSport.setImageResource(R.drawable.rio_o_seal_fe_blue);
                    break;
                case "FB":
                    imgSport.setImageResource(R.drawable.rio_o_seal_fb_blue);
                    break;
                case "GA":
                    imgSport.setImageResource(R.drawable.rio_o_seal_ga_blue);
                    break;
                case "GT":
                    imgSport.setImageResource(R.drawable.rio_o_seal_gt_blue);
                    break;
                case "GR":
                    imgSport.setImageResource(R.drawable.rio_o_seal_gr_blue);
                    break;
                case "GO":
                    imgSport.setImageResource(R.drawable.rio_o_seal_go_blue);
                    break;
                case "HB":
                    imgSport.setImageResource(R.drawable.rio_o_seal_hb_blue);
                    break;
                case "EQ":
                    imgSport.setImageResource(R.drawable.rio_o_seal_eq_blue);
                    break;
                case "HO":
                    imgSport.setImageResource(R.drawable.rio_o_seal_ho_blue);
                    break;
                case "JU":
                    imgSport.setImageResource(R.drawable.rio_o_seal_ju_blue);
                    break;
                case "WL":
                    imgSport.setImageResource(R.drawable.rio_o_seal_wl_blue);
                    break;
                case "WR":
                    imgSport.setImageResource(R.drawable.rio_o_seal_wr_blue);
                    break;
                case "OW":
                    imgSport.setImageResource(R.drawable.rio_o_seal_ow_blue);
                    break;
                case "SY":
                    imgSport.setImageResource(R.drawable.rio_o_seal_sy_blue);
                    break;
                case "SW":
                    imgSport.setImageResource(R.drawable.rio_o_seal_sw_blue);
                    break;
                case "MP":
                    imgSport.setImageResource(R.drawable.rio_o_seal_mp_blue);
                    break;
                case "WP":
                    imgSport.setImageResource(R.drawable.rio_o_seal_wp_blue);
                    break;
                case "RO":
                    imgSport.setImageResource(R.drawable.rio_o_seal_ro_blue);
                    break;
                case "RU":
                    imgSport.setImageResource(R.drawable.rio_o_seal_ru_blue);
                    break;
                case "DV":
                    imgSport.setImageResource(R.drawable.rio_o_seal_dv_blue);
                    break;
                case "TK":
                    imgSport.setImageResource(R.drawable.rio_o_seal_tk_blue);
                    break;
                case "TE":
                    imgSport.setImageResource(R.drawable.rio_o_seal_te_blue);
                    break;
                case "TT":
                    imgSport.setImageResource(R.drawable.rio_o_seal_tt_blue);
                    break;
                case "SH":
                    imgSport.setImageResource(R.drawable.rio_o_seal_sh_blue);
                    break;
                case "TR":
                    imgSport.setImageResource(R.drawable.rio_o_seal_tr_blue);
                    break;
                case "SA":
                    imgSport.setImageResource(R.drawable.rio_o_seal_sa_blue);
                    break;
                case "BV":
                    imgSport.setImageResource(R.drawable.rio_o_seal_bv_blue);
                    break;
                case "VO":
                    imgSport.setImageResource(R.drawable.rio_o_seal_vo_blue);
                    break;
                default:
                    imgSport.setImageResource(R.drawable.rio_o_seal_xx_blue);
                    break;
            }

            v.setTag(medalha);
        }

        return v;
    }

}