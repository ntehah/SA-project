package com.SA.Avatar.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Avatar {
    @Id
    private String id;
    private Element head, hair, eye, eyebrow, nose, mouth, ears, body, hat, top, top_colour, hat_colour;

    public Avatar(String id, Element head, Element hair, Element eye, Element eyebrow, Element nose, Element mouth, Element ears, Element body, Element hat, Element top, Element top_colour, Element hat_colour) {
        this.id = id;
        this.head = head;
        this.hair = hair;
        this.eye = eye;
        this.eyebrow = eyebrow;
        this.nose = nose;
        this.mouth = mouth;
        this.ears = ears;
        this.body = body;
        this.hat = hat;
        this.top = top;
        this.top_colour = top_colour;
        this.hat_colour = hat_colour;
    }

    public Element getVariable(String variableName) {
        switch (variableName) {
            case "head":
                return head;
            case "hair":
                return hair;
            case "eye":
                return eye;
            case "eyebrow":
                return eyebrow;
            case "nose":
                return nose;
            case "mouth":
                return mouth;
            case "ears":
                return ears;
            case "body":
                return body;
            case "hat":
                return hat;
            case "top":
                return top;
            case "top_colour":
                return top_colour;
            case "hat_colour":
                return hat_colour;
            default:
                throw new IllegalArgumentException("Invalid variable name: " + variableName);
        }
    }
    public void setVariable(String variableName, Element value) {
        switch (variableName) {
            case "head":
                setHead(value);
                break;
            case "hair":
                setHair(value);
                break;
            case "eye":
                setEye(value);
                break;
            case "eyebrow":
                setEyebrow(value);
                break;
            case "nose":
                setNose(value);
                break;
            case "mouth":
                setMouth(value);
                break;
            case "ears":
                setEars(value);
                break;
            case "body":
                setBody(value);
                break;
            case "hat":
                setHat(value);
                break;
            case "top":
                setTop(value);
                break;
            case "top_colour":
                setTop_colour(value);
                break;
            case "hat_colour":
                setHat_colour(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid variable name: " + variableName);
        }
    }
}
