package com.test.fampaydemo.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.test.fampaydemo.R;
import com.test.fampaydemo.data.model.Card;
import com.test.fampaydemo.data.model.CardGroup;

import java.util.List;

public class CardGroupsAdapter extends RecyclerView.Adapter<CardGroupsAdapter.CardGroupViewHolder> {
    private List<CardGroup> cardGroups;

    public CardGroupsAdapter(List<CardGroup> data) {
        this.cardGroups = data;
    }

    public void setData(List<CardGroup> data) {
        this.cardGroups = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardGroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CardGroupViewHolder viewHolder;
        switch (viewType) {
            case 1:
                viewHolder = new CardGroupViewHolderHC1(layoutInflater.inflate(R.layout.viewholder_hc1, parent, false));
                break;
            case 3:
                viewHolder = new CardGroupViewHolderHC3(layoutInflater.inflate(R.layout.viewholder_hc3, parent, false));
                break;
            case 5:
                viewHolder = new CardGroupViewHolderHC5(layoutInflater.inflate(R.layout.viewholder_hc5, parent, false));
                break;
            case 6:
                viewHolder = new CardGroupViewHolderHC6(layoutInflater.inflate(R.layout.viewholder_hc6, parent, false));
                break;
            case 9:
                viewHolder = new CardGroupViewHolderHC9(layoutInflater.inflate(R.layout.viewholder_hc9, parent, false));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardGroupViewHolder holder, int position) {
        holder.bind(cardGroups.get(position));
    }

    @Override
    public int getItemCount() {
        return cardGroups.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (cardGroups.get(position).getDesignType()) {
            case HC1:
                return 1;
            case HC3:
                return 3;
            case HC5:
                return 5;
            case HC6:
                return 6;
            case HC9:
                return 9;
            default:
                return -1;
        }
    }

    // CardGroupViewHolder subclasses
    public static abstract class CardGroupViewHolder extends RecyclerView.ViewHolder {
        public CardGroupViewHolder(View view) {
            super(view);
        }

        public abstract void bind(CardGroup data);

        SpannableStringBuilder formatString(Card.FormattedText formattedText) {
            SpannableStringBuilder stringBuilder = new SpannableStringBuilder(formattedText.getText());
            for (Card.FormattedTextEntity entity : formattedText.getEntities()) {
                int start = formattedText.getText().indexOf('{'), end = start + entity.getText().length();
                stringBuilder = stringBuilder.replace(start, start + 1, entity.getText());

                if (entity.getColor() != null)
                    stringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(entity.getColor())), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                if (entity.getUrl() != null)
                    stringBuilder.setSpan(new URLSpan(entity.getUrl()), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                if (entity.getFontStyle() != null) {
                    switch (entity.getFontStyle()) {
                        case "underline":
                            stringBuilder.setSpan(new UnderlineSpan(), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            break;
                        case "italic":
                            stringBuilder.setSpan(new StyleSpan(Typeface.ITALIC), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            }

            return stringBuilder;
        }
    }

    public static class CardGroupViewHolderHC1 extends CardGroupViewHolder {
        public CardGroupViewHolderHC1(View view) {
            super(view);
        }

        @Override
        public void bind(CardGroup data) {

        }
    }

    public static class CardGroupViewHolderHC3 extends CardGroupViewHolder {
        private final TextView titleTextView, descriptionTextView;
        private LinearLayoutCompat ctaContainer;

        public CardGroupViewHolderHC3(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.title_textview);
            descriptionTextView = view.findViewById(R.id.description_textview);
            ctaContainer = view.findViewById(R.id.cta_container);
        }

        @Override
        public void bind(CardGroup data) {
            titleTextView.setText(formatString(data.getCards().get(0).getFormattedTitle()));
            descriptionTextView.setText(formatString(data.getCards().get(0).getFormattedDescription()));
        }
    }

    public static class CardGroupViewHolderHC5 extends CardGroupViewHolder {
        public CardGroupViewHolderHC5(View view) {
            super(view);
        }

        @Override
        public void bind(CardGroup data) {

        }
    }

    public static class CardGroupViewHolderHC6 extends CardGroupViewHolder {
        public CardGroupViewHolderHC6(View view) {
            super(view);
        }

        @Override
        public void bind(CardGroup data) {

        }
    }

    public static class CardGroupViewHolderHC9 extends CardGroupViewHolder {
        public CardGroupViewHolderHC9(View view) {
            super(view);
        }

        @Override
        public void bind(CardGroup data) {

        }
    }
}
