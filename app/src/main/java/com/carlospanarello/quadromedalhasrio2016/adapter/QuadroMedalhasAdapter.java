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
import com.carlospanarello.quadromedalhasrio2016.model.ItemQuadroMedalha;

import java.util.List;

/**
 * Created by carlospanarello on 11/08/16.
 */
public class QuadroMedalhasAdapter extends ArrayAdapter<ItemQuadroMedalha> {

    private List<ItemQuadroMedalha> items;
    private int rowResourceID;
    ModelHelper db;
    ItemQuadroMedalha medalha;
    Context context;
    LayoutInflater vi;

    public QuadroMedalhasAdapter(Context context, int rowResourceId, List<ItemQuadroMedalha> items) {
        super(context, rowResourceId, items);
        this.context = context;
        this.rowResourceID = rowResourceId;
        this.items = items;
        vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // convertView is null when new row is needed
        View v = convertView;

        if(v == null) {
            // new row is needed to inflate new row
            v = vi.inflate(R.layout.item_quadro_medalha, parent, false);
        }

//
       /// View v = vi.inflate(rowResourceID, null);

        db = new ModelHelper(context);
        medalha = items.get(position);

        if (medalha != null) {
            TextView txtPosicao = (TextView) v.findViewById(R.id.position);
            TextView txtNomePais = (TextView) v.findViewById(R.id.descCountry);
            TextView txtGold = (TextView) v.findViewById(R.id.goldCount);
            TextView txtSilver = (TextView) v.findViewById(R.id.silverCount);
            TextView txtBronze = (TextView) v.findViewById(R.id.bronzeCount);
            //TextView txtTotal = (TextView) v.findViewById(R.id.totalCount);
            ImageView imgFlag = (ImageView) v.findViewById(R.id.imgFlag);

            txtPosicao.setText(String.valueOf(medalha.getPosition()));
            txtNomePais.setText(String.valueOf(medalha.getName_country()));
            txtGold.setText(String.valueOf(medalha.getGold_count()));
            txtSilver.setText(String.valueOf(medalha.getSilver_count()));
            txtBronze.setText(String.valueOf(medalha.getBronze_count()));
            //txtTotal.setText(String.valueOf(medalha.getTotal_medals()));

            switch(medalha.getId_country()) {
                case "AFG":
                    imgFlag.setImageResource(R.drawable.rio_flag_afg);
                    break;
                case "RSA":
                    imgFlag.setImageResource(R.drawable.rio_flag_rsa);
                    break;
                case "ALB":
                    imgFlag.setImageResource(R.drawable.rio_flag_alb);
                    break;
                case "GER":
                    imgFlag.setImageResource(R.drawable.rio_flag_ger);
                    break;
                case "AND":
                    imgFlag.setImageResource(R.drawable.rio_flag_and);
                    break;
                case "ANG":
                    imgFlag.setImageResource(R.drawable.rio_flag_ang);
                    break;
                case "ANT":
                    imgFlag.setImageResource(R.drawable.rio_flag_ant);
                    break;
                // case "IOA": imgFlag.setImageResource(R.drawable.rio_flag_ioa); break;
                case "KSA":
                    imgFlag.setImageResource(R.drawable.rio_flag_ksa);
                    break;
                case "ALG":
                    imgFlag.setImageResource(R.drawable.rio_flag_alg);
                    break;
                case "ARG":
                    imgFlag.setImageResource(R.drawable.rio_flag_arg);
                    break;
                case "ARM":
                    imgFlag.setImageResource(R.drawable.rio_flag_arm);
                    break;
                case "ARU":
                    imgFlag.setImageResource(R.drawable.rio_flag_aru);
                    break;
                case "AUS":
                    imgFlag.setImageResource(R.drawable.rio_flag_aus);
                    break;
                case "AUT":
                    imgFlag.setImageResource(R.drawable.rio_flag_aut);
                    break;
                case "AZE":
                    imgFlag.setImageResource(R.drawable.rio_flag_aze);
                    break;
                case "BAH":
                    imgFlag.setImageResource(R.drawable.rio_flag_bah);
                    break;
                case "BAN":
                    imgFlag.setImageResource(R.drawable.rio_flag_ban);
                    break;
                case "BAR":
                    imgFlag.setImageResource(R.drawable.rio_flag_bar);
                    break;
                case "BRN":
                    imgFlag.setImageResource(R.drawable.rio_flag_brn);
                    break;
                case "BLR":
                    imgFlag.setImageResource(R.drawable.rio_flag_blr);
                    break;
                case "BEL":
                    imgFlag.setImageResource(R.drawable.rio_flag_bel);
                    break;
                case "BIZ":
                    imgFlag.setImageResource(R.drawable.rio_flag_biz);
                    break;
                case "BEN":
                    imgFlag.setImageResource(R.drawable.rio_flag_ben);
                    break;
                case "BER":
                    imgFlag.setImageResource(R.drawable.rio_flag_ber);
                    break;
                case "BOL":
                    imgFlag.setImageResource(R.drawable.rio_flag_bol);
                    break;
                case "BIH":
                    imgFlag.setImageResource(R.drawable.rio_flag_bih);
                    break;
                case "BOT":
                    imgFlag.setImageResource(R.drawable.rio_flag_bot);
                    break;
                case "BRA":
                    imgFlag.setImageResource(R.drawable.rio_flag_bra);
                    break;
                case "BRU":
                    imgFlag.setImageResource(R.drawable.rio_flag_bru);
                    break;
                case "BUL":
                    imgFlag.setImageResource(R.drawable.rio_flag_bul);
                    break;
                case "BUR":
                    imgFlag.setImageResource(R.drawable.rio_flag_bur);
                    break;
                case "BDI":
                    imgFlag.setImageResource(R.drawable.rio_flag_bdi);
                    break;
                case "BHU":
                    imgFlag.setImageResource(R.drawable.rio_flag_bhu);
                    break;
                case "CPV":
                    imgFlag.setImageResource(R.drawable.rio_flag_cpv);
                    break;
                case "CMR":
                    imgFlag.setImageResource(R.drawable.rio_flag_cmr);
                    break;
                case "CAM":
                    imgFlag.setImageResource(R.drawable.rio_flag_cam);
                    break;
                case "CAN":
                    imgFlag.setImageResource(R.drawable.rio_flag_can);
                    break;
                case "QAT":
                    imgFlag.setImageResource(R.drawable.rio_flag_qat);
                    break;
                case "KAZ":
                    imgFlag.setImageResource(R.drawable.rio_flag_kaz);
                    break;
                case "CHA":
                    imgFlag.setImageResource(R.drawable.rio_flag_cha);
                    break;
                case "CHI":
                    imgFlag.setImageResource(R.drawable.rio_flag_chi);
                    break;
                case "CHN":
                    imgFlag.setImageResource(R.drawable.rio_flag_chn);
                    break;
                case "CYP":
                    imgFlag.setImageResource(R.drawable.rio_flag_cyp);
                    break;
                case "SIN":
                    imgFlag.setImageResource(R.drawable.rio_flag_sin);
                    break;
                case "COL":
                    imgFlag.setImageResource(R.drawable.rio_flag_col);
                    break;
                case "COM":
                    imgFlag.setImageResource(R.drawable.rio_flag_com);
                    break;
                case "CGO":
                    imgFlag.setImageResource(R.drawable.rio_flag_cgo);
                    break;
                case "COD":
                    imgFlag.setImageResource(R.drawable.rio_flag_cod);
                    break;
                case "CIV":
                    imgFlag.setImageResource(R.drawable.rio_flag_civ);
                    break;
                case "CRC":
                    imgFlag.setImageResource(R.drawable.rio_flag_crc);
                    break;
                case "CRO":
                    imgFlag.setImageResource(R.drawable.rio_flag_cro);
                    break;
                case "CUB":
                    imgFlag.setImageResource(R.drawable.rio_flag_cub);
                    break;
                case "DEN":
                    imgFlag.setImageResource(R.drawable.rio_flag_den);
                    break;
                case "DJI":
                    imgFlag.setImageResource(R.drawable.rio_flag_dji);
                    break;
                case "DMA":
                    imgFlag.setImageResource(R.drawable.rio_flag_dma);
                    break;
                case "EGY":
                    imgFlag.setImageResource(R.drawable.rio_flag_egy);
                    break;
                case "ESA":
                    imgFlag.setImageResource(R.drawable.rio_flag_esa);
                    break;
                case "UAE":
                    imgFlag.setImageResource(R.drawable.rio_flag_uae);
                    break;
                case "ECU":
                    imgFlag.setImageResource(R.drawable.rio_flag_ecu);
                    break;
                case "ERI":
                    imgFlag.setImageResource(R.drawable.rio_flag_eri);
                    break;
                case "SVK":
                    imgFlag.setImageResource(R.drawable.rio_flag_svk);
                    break;
                case "SLO":
                    imgFlag.setImageResource(R.drawable.rio_flag_slo);
                    break;
                case "ESP":
                    imgFlag.setImageResource(R.drawable.rio_flag_esp);
                    break;
                case "USA":
                    imgFlag.setImageResource(R.drawable.rio_flag_usa);
                    break;
                case "EST":
                    imgFlag.setImageResource(R.drawable.rio_flag_est);
                    break;
                case "ETH":
                    imgFlag.setImageResource(R.drawable.rio_flag_eth);
                    break;
                case "MKD":
                    imgFlag.setImageResource(R.drawable.rio_flag_mkd);
                    break;
                case "RUS":
                    imgFlag.setImageResource(R.drawable.rio_flag_rus);
                    break;
                // case "FIJ": imgFlag.setImageResource(R.drawable.rio_flag_fij); break;
                case "PHI":
                    imgFlag.setImageResource(R.drawable.rio_flag_phi);
                    break;
                case "FIN":
                    imgFlag.setImageResource(R.drawable.rio_flag_fin);
                    break;
                case "FRA":
                    imgFlag.setImageResource(R.drawable.rio_flag_fra);
                    break;
                case "GAB":
                    imgFlag.setImageResource(R.drawable.rio_flag_gab);
                    break;
                case "GHA":
                    imgFlag.setImageResource(R.drawable.rio_flag_gha);
                    break;
                case "GEO":
                    imgFlag.setImageResource(R.drawable.rio_flag_geo);
                    break;
                case "GBR":
                    imgFlag.setImageResource(R.drawable.rio_flag_gbr);
                    break;
                case "GRN":
                    imgFlag.setImageResource(R.drawable.rio_flag_grn);
                    break;
                case "GRE":
                    imgFlag.setImageResource(R.drawable.rio_flag_gre);
                    break;
                case "GUM":
                    imgFlag.setImageResource(R.drawable.rio_flag_gum);
                    break;
                case "GUA":
                    imgFlag.setImageResource(R.drawable.rio_flag_gua);
                    break;
                case "GUY":
                    imgFlag.setImageResource(R.drawable.rio_flag_guy);
                    break;
                case "GUI":
                    imgFlag.setImageResource(R.drawable.rio_flag_gui);
                    break;
                case "GEQ":
                    imgFlag.setImageResource(R.drawable.rio_flag_geq);
                    break;
                case "GBS":
                    imgFlag.setImageResource(R.drawable.rio_flag_gbs);
                    break;
                case "GAM":
                    imgFlag.setImageResource(R.drawable.rio_flag_gam);
                    break;
                case "HAI":
                    imgFlag.setImageResource(R.drawable.rio_flag_hai);
                    break;
                case "HON":
                    imgFlag.setImageResource(R.drawable.rio_flag_hon);
                    break;
                case "HKG":
                    imgFlag.setImageResource(R.drawable.rio_flag_hkg);
                    break;
                case "HUN":
                    imgFlag.setImageResource(R.drawable.rio_flag_hun);
                    break;
                case "CAY":
                    imgFlag.setImageResource(R.drawable.rio_flag_cay);
                    break;
                case "COK":
                    imgFlag.setImageResource(R.drawable.rio_flag_cok);
                    break;
                case "MHL":
                    imgFlag.setImageResource(R.drawable.rio_flag_mhl);
                    break;
                case "SOL":
                    imgFlag.setImageResource(R.drawable.rio_flag_sol);
                    break;
                case "IVB":
                    imgFlag.setImageResource(R.drawable.rio_flag_ivb);
                    break;
                case "ISV":
                    imgFlag.setImageResource(R.drawable.rio_flag_isv);
                    break;
                case "IND":
                    imgFlag.setImageResource(R.drawable.rio_flag_ind);
                    break;
                case "INA":
                    imgFlag.setImageResource(R.drawable.rio_flag_ina);
                    break;
                case "IRI":
                    imgFlag.setImageResource(R.drawable.rio_flag_iri);
                    break;
                case "IRQ":
                    imgFlag.setImageResource(R.drawable.rio_flag_irq);
                    break;
                case "IRL":
                    imgFlag.setImageResource(R.drawable.rio_flag_irl);
                    break;
                case "ISL":
                    imgFlag.setImageResource(R.drawable.rio_flag_isl);
                    break;
                case "ISR":
                    imgFlag.setImageResource(R.drawable.rio_flag_isr);
                    break;
                case "ITA":
                    imgFlag.setImageResource(R.drawable.rio_flag_ita);
                    break;
                case "YEM":
                    imgFlag.setImageResource(R.drawable.rio_flag_yem);
                    break;
                case "JAM":
                    imgFlag.setImageResource(R.drawable.rio_flag_jam);
                    break;
                case "JPN":
                    imgFlag.setImageResource(R.drawable.rio_flag_jpn);
                    break;
                case "JOR":
                    imgFlag.setImageResource(R.drawable.rio_flag_jor);
                    break;
                case "KIR":
                    imgFlag.setImageResource(R.drawable.rio_flag_kir);
                    break;
                case "KOS":
                    imgFlag.setImageResource(R.drawable.rio_flag_kos);
                    break;
                case "KUW":
                    imgFlag.setImageResource(R.drawable.rio_flag_kuw);
                    break;
                case "LAO":
                    imgFlag.setImageResource(R.drawable.rio_flag_lao);
                    break;
                case "LES":
                    imgFlag.setImageResource(R.drawable.rio_flag_les);
                    break;
                case "LAT":
                    imgFlag.setImageResource(R.drawable.rio_flag_lat);
                    break;
                case "LIB":
                    imgFlag.setImageResource(R.drawable.rio_flag_lib);
                    break;
                case "LBR":
                    imgFlag.setImageResource(R.drawable.rio_flag_lbr);
                    break;
                case "LBA":
                    imgFlag.setImageResource(R.drawable.rio_flag_lba);
                    break;
                case "LIE":
                    imgFlag.setImageResource(R.drawable.rio_flag_lie);
                    break;
                case "LTU":
                    imgFlag.setImageResource(R.drawable.rio_flag_ltu);
                    break;
                case "LUX":
                    imgFlag.setImageResource(R.drawable.rio_flag_lux);
                    break;
                case "MAD":
                    imgFlag.setImageResource(R.drawable.rio_flag_mad);
                    break;
                case "MAS":
                    imgFlag.setImageResource(R.drawable.rio_flag_mas);
                    break;
                case "MAW":
                    imgFlag.setImageResource(R.drawable.rio_flag_maw);
                    break;
                case "MDV":
                    imgFlag.setImageResource(R.drawable.rio_flag_mdv);
                    break;
                case "MLI":
                    imgFlag.setImageResource(R.drawable.rio_flag_mli);
                    break;
                case "MLT":
                    imgFlag.setImageResource(R.drawable.rio_flag_mlt);
                    break;
                case "MAR":
                    imgFlag.setImageResource(R.drawable.rio_flag_mar);
                    break;
                case "MRI":
                    imgFlag.setImageResource(R.drawable.rio_flag_mri);
                    break;
                case "MTN":
                    imgFlag.setImageResource(R.drawable.rio_flag_mtn);
                    break;
                case "MEX":
                    imgFlag.setImageResource(R.drawable.rio_flag_mex);
                    break;
                case "FSM":
                    imgFlag.setImageResource(R.drawable.rio_flag_fsm);
                    break;
                case "MGL":
                    imgFlag.setImageResource(R.drawable.rio_flag_mgl);
                    break;
                case "MNE":
                    imgFlag.setImageResource(R.drawable.rio_flag_mne);
                    break;
                case "MOZ":
                    imgFlag.setImageResource(R.drawable.rio_flag_moz);
                    break;
                case "MYA":
                    imgFlag.setImageResource(R.drawable.rio_flag_mya);
                    break;
                case "MON":
                    imgFlag.setImageResource(R.drawable.rio_flag_mon);
                    break;
                case "NAM":
                    imgFlag.setImageResource(R.drawable.rio_flag_nam);
                    break;
                case "NRU":
                    imgFlag.setImageResource(R.drawable.rio_flag_nru);
                    break;
                case "NEP":
                    imgFlag.setImageResource(R.drawable.rio_flag_nep);
                    break;
                case "NCA":
                    imgFlag.setImageResource(R.drawable.rio_flag_nca);
                    break;
                case "NIG":
                    imgFlag.setImageResource(R.drawable.rio_flag_nig);
                    break;
                case "NGR":
                    imgFlag.setImageResource(R.drawable.rio_flag_ngr);
                    break;
                case "NOR":
                    imgFlag.setImageResource(R.drawable.rio_flag_nor);
                    break;
                case "NZL":
                    imgFlag.setImageResource(R.drawable.rio_flag_nzl);
                    break;
                case "OMA":
                    imgFlag.setImageResource(R.drawable.rio_flag_oma);
                    break;
                case "NED":
                    imgFlag.setImageResource(R.drawable.rio_flag_ned);
                    break;
                case "PLW":
                    imgFlag.setImageResource(R.drawable.rio_flag_plw);
                    break;
                case "PLE":
                    imgFlag.setImageResource(R.drawable.rio_flag_ple);
                    break;
                case "PAN":
                    imgFlag.setImageResource(R.drawable.rio_flag_pan);
                    break;
                case "PNG":
                    imgFlag.setImageResource(R.drawable.rio_flag_png);
                    break;
                case "PAK":
                    imgFlag.setImageResource(R.drawable.rio_flag_pak);
                    break;
                case "PAR":
                    imgFlag.setImageResource(R.drawable.rio_flag_par);
                    break;
                case "PER":
                    imgFlag.setImageResource(R.drawable.rio_flag_per);
                    break;
                case "POL":
                    imgFlag.setImageResource(R.drawable.rio_flag_pol);
                    break;
                case "PUR":
                    imgFlag.setImageResource(R.drawable.rio_flag_pur);
                    break;
                case "POR":
                    imgFlag.setImageResource(R.drawable.rio_flag_por);
                    break;
                case "KGZ":
                    imgFlag.setImageResource(R.drawable.rio_flag_kgz);
                    break;
                case "KEN":
                    imgFlag.setImageResource(R.drawable.rio_flag_ken);
                    break;
                case "CAF":
                    imgFlag.setImageResource(R.drawable.rio_flag_caf);
                    break;
                case "KOR":
                    imgFlag.setImageResource(R.drawable.rio_flag_kor);
                    break;
                case "MDA":
                    imgFlag.setImageResource(R.drawable.rio_flag_mda);
                    break;
                case "DOM":
                    imgFlag.setImageResource(R.drawable.rio_flag_dom);
                    break;
                case "CZE":
                    imgFlag.setImageResource(R.drawable.rio_flag_cze);
                    break;
                case "ROU":
                    imgFlag.setImageResource(R.drawable.rio_flag_rou);
                    break;
                // case "ROT": imgFlag.setImageResource(R.drawable.rio_flag_rot); break;
                case "PRK":
                    imgFlag.setImageResource(R.drawable.rio_flag_prk);
                    break;
                case "RWA":
                    imgFlag.setImageResource(R.drawable.rio_flag_rwa);
                    break;
                case "SAM":
                    imgFlag.setImageResource(R.drawable.rio_flag_sam);
                    break;
                case "ASA":
                    imgFlag.setImageResource(R.drawable.rio_flag_asa);
                    break;
                case "SMR":
                    imgFlag.setImageResource(R.drawable.rio_flag_smr);
                    break;
                case "LCA":
                    imgFlag.setImageResource(R.drawable.rio_flag_lca);
                    break;
                case "SKN":
                    imgFlag.setImageResource(R.drawable.rio_flag_skn);
                    break;
                case "STP":
                    imgFlag.setImageResource(R.drawable.rio_flag_stp);
                    break;
                case "VIN":
                    imgFlag.setImageResource(R.drawable.rio_flag_vin);
                    break;
                case "SEY":
                    imgFlag.setImageResource(R.drawable.rio_flag_sey);
                    break;
                case "SEN":
                    imgFlag.setImageResource(R.drawable.rio_flag_sen);
                    break;
                case "SLE":
                    imgFlag.setImageResource(R.drawable.rio_flag_sle);
                    break;
                case "SRB":
                    imgFlag.setImageResource(R.drawable.rio_flag_srb);
                    break;
                case "SYR":
                    imgFlag.setImageResource(R.drawable.rio_flag_syr);
                    break;
                case "SOM":
                    imgFlag.setImageResource(R.drawable.rio_flag_som);
                    break;
                case "SRI":
                    imgFlag.setImageResource(R.drawable.rio_flag_sri);
                    break;
                case "SWZ":
                    imgFlag.setImageResource(R.drawable.rio_flag_swz);
                    break;
                case "SUD":
                    imgFlag.setImageResource(R.drawable.rio_flag_sud);
                    break;
                case "SSD":
                    imgFlag.setImageResource(R.drawable.rio_flag_ssd);
                    break;
                case "SWE":
                    imgFlag.setImageResource(R.drawable.rio_flag_swe);
                    break;
                case "SUI":
                    imgFlag.setImageResource(R.drawable.rio_flag_sui);
                    break;
                case "SUR":
                    imgFlag.setImageResource(R.drawable.rio_flag_sur);
                    break;
                case "TJK":
                    imgFlag.setImageResource(R.drawable.rio_flag_tjk);
                    break;
                case "THA":
                    imgFlag.setImageResource(R.drawable.rio_flag_tha);
                    break;
                case "TPE":
                    imgFlag.setImageResource(R.drawable.rio_flag_tpe);
                    break;
                case "TAN":
                    imgFlag.setImageResource(R.drawable.rio_flag_tan);
                    break;
                case "TLS":
                    imgFlag.setImageResource(R.drawable.rio_flag_tls);
                    break;
                case "TOG":
                    imgFlag.setImageResource(R.drawable.rio_flag_tog);
                    break;
                case "TGA":
                    imgFlag.setImageResource(R.drawable.rio_flag_tga);
                    break;
                case "TTO":
                    imgFlag.setImageResource(R.drawable.rio_flag_tto);
                    break;
                case "TUN":
                    imgFlag.setImageResource(R.drawable.rio_flag_tun);
                    break;
                case "TKM":
                    imgFlag.setImageResource(R.drawable.rio_flag_tkm);
                    break;
                case "TUR":
                    imgFlag.setImageResource(R.drawable.rio_flag_tur);
                    break;
                case "TUV":
                    imgFlag.setImageResource(R.drawable.rio_flag_tuv);
                    break;
                case "UKR":
                    imgFlag.setImageResource(R.drawable.rio_flag_ukr);
                    break;
                case "UGA":
                    imgFlag.setImageResource(R.drawable.rio_flag_uga);
                    break;
                case "URU":
                    imgFlag.setImageResource(R.drawable.rio_flag_uru);
                    break;
                case "UZB":
                    imgFlag.setImageResource(R.drawable.rio_flag_uzb);
                    break;
                case "VAN":
                    imgFlag.setImageResource(R.drawable.rio_flag_van);
                    break;
                case "VEN":
                    imgFlag.setImageResource(R.drawable.rio_flag_ven);
                    break;
                case "VIE":
                    imgFlag.setImageResource(R.drawable.rio_flag_vie);
                    break;
                case "ZIM":
                    imgFlag.setImageResource(R.drawable.rio_flag_zim);
                    break;
                default:
                    imgFlag.setImageResource(R.drawable.rio_flag_zzz);
                    break;
            }

            v.setTag(medalha);
        }

        return v;
    }
}
