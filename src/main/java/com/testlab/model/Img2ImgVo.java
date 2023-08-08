package com.testlab.model;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: stable-diffusion-webui-api-service
 * @Author: zyb
 * @CreateTime: 2023-08-08 16:26:18 星期二
 * @FileName: Img2ImgVo
 * @Description: 用于接受img2img参数
 */
public class Img2ImgVo {

    private List<String> init_images;
    private Integer resize_mode;
    private Integer denoising_strength;
    private Integer image_cfg_scale;
    private String mask;
    private Integer mask_blur;
    private Integer mask_blur_x;
    private Integer mask_blur_y;
    private Integer inpainting_fill;
    private Boolean inpaint_full_res;
    private Integer inpaint_full_res_padding;
    private Integer inpainting_mask_invert;
    private Integer initial_noise_multiplier;
    private String prompt;
    private List<String> styles;
    private Integer seed;
    private Integer subseed;
    private Integer subseed_strength;
    private Integer seed_resize_from_h;
    private Integer seed_resize_from_w;
    private String sampler_name;
    private Integer batch_size;
    private Integer n_iter;
    private Integer steps;
    private Integer cfg_scale;
    private Integer width;
    private Integer height;
    private Boolean restore_faces;
    private Boolean tiling;
    private Boolean do_not_save_samples;
    private Boolean do_not_save_grid;
    private String negative_prompt;
    private Integer eta;
    private Integer s_min_uncond;
    private Integer s_churn;
    private Integer s_tmax;
    private Integer s_tmin;
    private Integer s_noise;
    private Map<String, Object> override_settings;
    private Boolean override_settings_restore_afterwards;
    private List<String> script_args;
    private String sampler_index;
    private Boolean include_init_images;
    private String script_name;
    private Boolean send_images;
    private Boolean save_images;
    private Map<String, Object> alwayson_scripts;

}
